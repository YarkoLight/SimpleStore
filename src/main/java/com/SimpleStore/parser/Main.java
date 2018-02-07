package com.SimpleStore.parser;

import java.io.File;

/**
 * Created by HOME on 12.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("catalina.home"));

        File file =
                new File("workspace:\\Server\\apache-tomcat-8.0.43\\resources\\newFolder\\qwe");


        file.mkdirs();

    }
}
