package com.edu.agh.exam.Vector;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleVector<T extends Number> implements Vector<T> {

    java.util.Vector<T> v;

    protected Object[] vector;
    public final int size;

    public SimpleVector(int n) {
        vector = new Object[n];
        this.size = n;
        for(int i = 0; i < n; i++) {
            vector[i] = null;
        }
    }

    @Override
    public T get(int index) throws InvalidIndexException {
        return (T)vector[index];
    }

    @Override
    public void set(int index, T value) throws InvalidIndexException {
        vector[index] = value;
    }

    @Override
    public void add(Vector<T> vector) throws InvalidDimensionalityException {
        Double result = 0d;
        try {
            for (int i = 0; i < this.size; i++) {
                result = ((T)this.vector[i]).doubleValue() + vector.get(i).doubleValue();
                this.vector[i] = (T) result;
            }
        } catch (InvalidIndexException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double dotProduct(Vector<T> vector) throws InvalidDimensionalityException, InvalidIndexException {
        if(this.size != ((SimpleVector)vector).size)
            throw new InvalidDimensionalityException("Dimensions not matching");
        Double result = 0d;

        System.out.println(this.size);

        for(int i = 0; i < this.size; i++) {
            result = Double.sum(result, (Double) this.vector[i] * (Double)vector.get(i));
        }

        System.out.println(result);
        return result;
    }

    private static List<String> mostFrequent(Map<String, Integer> m, int k) {
        if(m == null)
            return Collections.emptyList();

        List<String> result = new ArrayList<>(m.size());

        return m.entrySet()
                .stream()
                .filter(x -> x.getValue() > k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    private static Set<String> ids(String path) {
        Set<String> result = new HashSet<>();
        String util = null;


        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            byte[] source = Files.readAllBytes(Paths.get(path));
            util = new String(source, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("(.*,.*,)(-?\\d+)");
        Matcher matcher = pattern.matcher(util);

        while(matcher.find()) {
            result.add(matcher.group(2));
        }

        return result;
    }

    private static List<String> getColumn(String path, int col) throws IOException {
        List<String> result = new ArrayList<>();
        File file = new File(path);
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        for(String line : lines) {
            String[] array = line.split(",");
            result.add(array[col]);
        }
        return result;
    }

    public static void main(String[] args) throws InvalidIndexException, IOException {
        Vector<Double> v1 = new SimpleVector<>(3);
        Vector<Double> v2 = new SimpleVector<>(3);

        v1.set(0, 1.0d);
        v1.set(1, 2.0d);
        v1.set(2, 5.0d);

        v2.set(0, 1.0d);
        v2.set(1, 2.0d);
        v2.set(2, 3.0d);

        double result = 0d;
        try {
            result = v1.dotProduct(v2);
        } catch (InvalidDimensionalityException e) {
            e.printStackTrace();
        } catch (InvalidIndexException e) {
            e.printStackTrace();
        }


        Map<String, Integer> map = new HashMap<>();
        map.put("Pies", 10);
        map.put("Kot", 44);
        map.put("Kaczka", 2);
        map.put("Myszołów", 142);
        map.put("Szczur", 16);
        map.put("Wieloryb", 14);

        List<String> results = mostFrequent(map, 15);

        results.forEach(System.out::println);


        Set<String> pesels = new HashSet<>();

        pesels = ids("src/com/edu/agh/exam/Info.txt");

        pesels.forEach(System.out::println);

        System.out.println(result);

        List<String> column = getColumn("src/com/edu/agh/exam/Info.txt", 0);

        column.forEach(System.out::println);
    }


}
