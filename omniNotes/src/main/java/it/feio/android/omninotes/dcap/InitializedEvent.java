package it.feio.android.omninotes.dcap;

import sapphire.common.AppObjectStub;

/**
 * Created by howell on 1/18/18.
 */

public class InitializedEvent {
    private AppObjectStub appEntryPoint;

    public InitializedEvent(AppObjectStub appEntryPoint) {
        this.appEntryPoint  = appEntryPoint;
    }

    public AppObjectStub getAppEntryPoint() {
        return appEntryPoint;
    }
}
