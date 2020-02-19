package com.pipe42.test;

import com.pipe42.data.Application;
import com.pipe42.data.Data;
import com.pipe42.data.Project;

import java.util.ArrayList;
import java.util.List;

public class InititateJSON {

    public List initiateJson() {

        Application newApp = new Application("1", "Maya", "2019", "c:/maya", "", "This is our main app");

        List<Application> newData = new ArrayList<>();
        newData.add(newApp);

        return newData;

    }

}
