package it.feio.android.omninotes.dcap;

import android.os.AsyncTask;

import java.net.InetSocketAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import de.greenrobot.event.EventBus;
import sapphire.kernel.server.KernelServer;
import sapphire.kernel.server.KernelServerImpl;
import sapphire.oms.OMSServer;

/**
 * Created by howell on 1/18/18.
 */

public class InitializationTask extends AsyncTask<Boolean, Void, KernelServerImpl> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected KernelServerImpl doInBackground(Boolean... args) {
        boolean isServerMode = args[0];

        // todo: remove hard coded ip addresses
        InetSocketAddress kernelAddr = new InetSocketAddress("10.0.2.10", 22345);
        InetSocketAddress omsAddr = new InetSocketAddress("10.0.2.2", 22343);
        KernelServerImpl kernelServer = new KernelServerImpl(kernelAddr, omsAddr);

        if (isServerMode) {
            try{
                this.initKernelServer(kernelServer, kernelAddr);
                kernelServer.getMemoryStatThread().start();
            }catch(RemoteException e){
                e.printStackTrace();
                return null;
            } catch (NotBoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        return kernelServer;
    }

    private void initKernelServer(KernelServer kernelServer, InetSocketAddress kernelAddr) throws RemoteException, NotBoundException {
        KernelServer stub = (KernelServer) java.rmi.server.UnicastRemoteObject.exportObject(kernelServer, 0);
        java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(kernelAddr.getPort());
        registry.rebind("SapphireKernelServer", stub);

        KernelServerImpl.oms.registerKernelServer(kernelAddr);
    }

    @Override
    protected void onPostExecute(KernelServerImpl o) {
        //todo: handle null - exception error
        super.onPostExecute(o);
        EventBus.getDefault().post(new InitializedEvent(o));
    }
}
