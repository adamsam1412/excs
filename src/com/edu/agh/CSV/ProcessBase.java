package com.edu.agh.CSV;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

abstract class ProcessBase implements Processable {

    String filePath = "src/com/edu/agh/Zadanie.csv";
    List<ArrayList<String>> csv = new ArrayList<>();
    List<ArrayList<String>> resultColumns = new ArrayList<>();
    Path path = Paths.get(filePath);
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private final static String outputPath = "columns.csv";

    private void logList() {
        Iterator iterator = csv.iterator();

        while (iterator.hasNext()) {
            List<String> l = (List) iterator.next();
            for (String element : l)
                System.out.println(element + " ");
        }

    }

    private void logListResults() {

        Iterator iterator = resultColumns.iterator();

        while (iterator.hasNext()) {
            List<String> l = (List) iterator.next();
            for (String element : l)
                System.out.print(element + " ");
            System.out.print('\n');
        }

    }

    public void process() {
        loadFile();
        processFile();
        exportFile();
        logListResults();
        //System.out.println(csv.get(0));
    }

    private String processLine(String line) {

        try (Scanner scannerLine = new Scanner(line)) {
            scannerLine.useDelimiter(";");
            if (scannerLine.hasNext())
                return scannerLine.next();
            else
                return "";
        }
    }


    private void loadFile() {

        try (Scanner scanner = new Scanner(path, ENCODING.name())) {

            while (scanner.hasNextLine()) {
                Scanner s = new Scanner(scanner.nextLine());
                s.useDelimiter(";");
                ArrayList<String> util = new ArrayList<>();
                while (s.hasNext()) {

                    util.add(processLine(s.next()));
                    //System.out.println(e.size());
                }
                csv.add(util);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract void processFile();

    private void exportFile() {
        try (Writer writer = new BufferedWriter
                (new OutputStreamWriter
                        (new FileOutputStream(outputPath), ENCODING.name()))) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = resultColumns.iterator();
            while (iterator.hasNext()) {
                ArrayList<String> l = (ArrayList<String>) iterator.next();
                stringBuilder.delete(0, stringBuilder.length());
                for (String e : l) {

                    stringBuilder.append(e);
                    stringBuilder.append(",");
                }
                stringBuilder.append('\n');
                writer.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
