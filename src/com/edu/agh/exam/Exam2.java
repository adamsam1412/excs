package com.edu.agh.exam;

import com.edu.agh.exam.MatrixEx.Matrix;
import com.edu.agh.exam.MatrixEx.SparseMatrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Exam2 {


    static List<String> mostFrequent(final Map<String, Integer> map) {

        if(map.isEmpty())
            return Collections.emptyList();

        int max = map.values().stream().max(Comparator.naturalOrder()).get();

        return map.entrySet()
                .stream()
                .filter(x -> x.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {

            while(br.readLine() != null) counter++;

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);

        Path path = Paths.get("test.txt");
        try{
            long lines = Files.lines(path).count();
            System.out.println("Lines:" + lines);
        } catch (IOException e) {
            e.printStackTrace();
        }



        //hashCode() <- hexadecimal address of object, equals() verifies if objects are equal

        Map<String, Integer> map = new HashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);

        map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        map.entrySet().forEach(System.out::println);


        //3

        int a = 0b10101;

        long bigNumber = 10_000__0_0_0;

        //int b = 010101b;

        double d2 = 1.234e2;

        String str = "Ala".substring(1);

        SparseMatrix<Double> doubleMatrix = new SparseMatrix<>(3, 3);

        Matrix<Double> ann = new Matrix<Double>() {

            @Override
            public Double get(int row, int col) {
                return new Double(0);
            }
            @Override
            public void set(int row, int col, Double value) {

            }
        };


//        try {
//            throw new Error("abc");
//        } catch (RuntimeException ex) {
//            throw new RuntimeException("b");
//        } catch (Throwable ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            System.out.println("d");
//        }


        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 49, 60, 70));

        System.out.println(numbers.stream()
                .filter(x -> x % 3 == 0 || x % 7 == 0)
                .peek(System.out::println)
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println(numbers.stream()
                .filter(x -> x % 3 == 0 || x % 7 == 0)
                .reduce((i, j) -> i + j)

        );

        int max = numbers.stream()
                .filter(x -> x % 3 == 0 || x % 7 == 0)
                .reduce((i, j) -> i+j)
                .get();
        System.out.println(max);



        String content = null;

        try {

            byte[] source = Files.readAllBytes(Paths.get("src/com/edu/agh/exam/httpLog.txt"));
            content = new String(source, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("(ContentLength:)(-?\\d+)");

        Matcher matcher = pattern.matcher(content);

        int bytes = 0;

        while(matcher.find()) {

            try{
                bytes += Integer.parseInt(matcher.group(2));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println(content);
        System.out.println(bytes);


        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

        set.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        set.stream()
                .filter(x -> (x & 1) == 0)
                .forEach(System.out::println);

        for(int i : set) if((i & 1) == 0) System.out.println(i);

        set.forEach(x -> {
            if(x % 2 == 0)
                System.out.println("just foreach" + x);
        });


        long k = 10000000000L;
        float f = 3.14f;
        int[] ints = new int[]{1, 2};
        boolean flag = 0 == 0;
        String string = "Krak".substring(1, 3);






    }
}
