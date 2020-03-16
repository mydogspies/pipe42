package com.pipe42.prefs;

import com.pipe42.data.pojos.Data;
import com.pipe42.main.Main;

// TODO still only for testing - do NOT use for production

public class Reset {

    public void resetAll() {

        // reset user preferences to default values
        InitializeUserPreferences.initUserPrefs();

        // reset database to default
        ResetData reset = new ResetData();
        Data dbdata = reset.defaultData();

        // and write a new json
        Main.factory.getIO().writeAll(dbdata);

    }

}
