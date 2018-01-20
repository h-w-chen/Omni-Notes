package it.feio.android.omninotes.dcap;

import it.feio.android.omninotes.db.DbHelper;
import sapphire.app.SapphireObject;

/**
 * Created by howell on 1/19/18.
 */

public class OmniNotesManager implements SapphireObject {
    public DbHelper getDbHelper(){
        return DbHelper.getInstance();
    }
}
