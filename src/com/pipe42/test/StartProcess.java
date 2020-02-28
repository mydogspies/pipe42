package com.pipe42.test;

import com.pipe42.system.ProcessMongoDB;

public class StartProcess {

    public static void main(String[] args) {

        Process proc = ProcessMongoDB.startMongoDB();
        System.out.println(proc);

    }

}
