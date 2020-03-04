package com.pipe42.prefs;

import com.pipe42.data.DatabaseJson;
import com.pipe42.data.pojos.Data;

public class Reset {

    public void resetAll() {

        // reset user preferences to default values
        InitializeUserPreferences.initUserPrefs();

        // reset database to default
        ResetData reset = new ResetData();
        Data dbdata = reset.defaultData();

        DatabaseJson dbj = new DatabaseJson();
        dbj.writeJsonData(dbdata);

    }

}
