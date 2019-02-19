package com.edu.agh.CopyFile;

import java.io.File;

public class Display {

    public static void display(File catalog){
        File[] content = catalog.listFiles();

        for(File f : content){
            System.out.println(f.getName());
        }
    }
}
