package com.agh;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

abstract class TextProcessorBase {

    Scanner scanner;
    private final static String FILE_NAME = "http://www.gutenberg.org/cache/epub/43064/pg43064.txt";
    //private final static String FILE_NAME = "src/test.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    //private final Path filePath = Paths.get(FILE_NAME);
    protected List<String> words = new ArrayList<>();
    protected Map<String, Integer> histogram = new HashMap<>();
    protected Map<String, Integer> resultTopFrequentMap = new LinkedHashMap<>();
    private final static String outputPath = "test.txt";
    private final static String outputPathTopFrequent = "topFrequent.txt";
    //protected AbstractMap<String, Integer> histogram = new ConcurrentHashMap<>(); test if is it faster than
    // HashMap, TreeMap, it's not for this amount of data

    private void logMap(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
        System.out.println(map.size());
    }

    private void logList() {
        for (String element : words)
            System.out.println(element + " ");
    }


    public void process() throws IOException {
        loadFile();
        processData();
        exportData();
        exportData(outputPathTopFrequent, resultTopFrequentMap);
        logMap(resultTopFrequentMap);

    }


    private String processLine(String line) throws IOException {

        try (Scanner scannerLine = new Scanner(line)) {

            scannerLine.useDelimiter(" ");

            if (scannerLine.hasNext())
                return scannerLine.next();
            else
                return "";

        }
    }


    private void loadFile() throws IOException {

        URL url = new URL(FILE_NAME);

        try (Scanner scanner = new Scanner(url.openStream(), ENCODING.name())) {
            while (scanner.hasNextLine()) {
                Scanner s = new Scanner(scanner.nextLine());
                while (s.hasNext()) {
                    words.add(processLine(s.next()));
                }
            }
        }
    }

    public abstract void processData();

    private void exportData() throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputPath), ENCODING.name())
        )) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(entry.getKey() + " ");
                stringBuilder.append(entry.getValue() + "\n");
                writer.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportData(String outputPath, Map<String, Integer> map) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputPath), ENCODING.name())
        )) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(entry.getKey() + " ");
                stringBuilder.append(entry.getValue() + "\n");
                writer.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
