package it.feio.android.omninotes.dcap;

import sapphire.app.AppEntryPoint;
import sapphire.app.AppObjectNotCreatedException;
import sapphire.common.AppObjectStub;
import sapphire.runtime.Sapphire;

/**
 * Created by howell on 1/19/18.
 */

public class App implements AppEntryPoint {
    @Override
    public AppObjectStub start() throws AppObjectNotCreatedException {
        return  (AppObjectStub) Sapphire.new_(OmniNotesManager.class);
    }
}
