package it.feio.android.omninotes.dcap;

/**
 * Created by howell on 1/19/18.
 */

public final class DCAPRoot {
    private DCAPRoot() {}

    private static OmniNotesManager instance = null;

    public static OmniNotesManager getInstance() {
        return instance;
    }

    public static void setInstance(OmniNotesManager instance) {
        DCAPRoot.instance = instance;
    }
}
