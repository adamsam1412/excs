package com.edu.agh.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    String logFile;

    public Regex(Path file) {
        File source = file.toFile();

        try(Scanner scanner = new Scanner(file)) {
            logFile = scanner.useDelimiter("/").next();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    private void readFile(File file, String output) {

        try(Scanner scanner = new Scanner(file)) {
            output = scanner.useDelimiter("\\n").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int computePayload() {
        String rgx = "(ContentLength:)(-?\\d+)";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(logFile);
        int payload = 0;

        while(matcher.find()) {
            //System.out.println(matcher.group(2));
            try {
                payload += Integer.valueOf(matcher.group(2));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return payload;
    }

    public static void main(String[] args) {
        Regex rx = new Regex(Paths.get("src/com/edu/agh/exam/httpLog.txt"));
        System.out.println(rx.logFile);
        rx.computePayload();

        System.out.println(rx.computePayload());

    }


}
