package com.edu.agh.CopyFile;

import java.io.File;
import java.io.IOException;

public class CopyTest {

    public static void main(String[] args){

        File test = new File("C:\\Users\\PLADSAM\\workspace\\TextProcessing");
        try {
            Copy.copy("columns.csv", "src/outpp", true);
            Display.display(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
