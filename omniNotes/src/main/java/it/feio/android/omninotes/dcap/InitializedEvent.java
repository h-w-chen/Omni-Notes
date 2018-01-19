package it.feio.android.omninotes.dcap;

import sapphire.kernel.server.KernelServerImpl;
import sapphire.oms.OMSServer;

/**
 * Created by howell on 1/18/18.
 */

public class InitializedEvent {
    private KernelServerImpl kernelServer;

    public InitializedEvent(KernelServerImpl kernelServer) {
        this.kernelServer = kernelServer;
    }
}
