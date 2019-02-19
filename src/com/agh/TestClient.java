package com.agh;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestClient {

    static String generateRandomWords(int numberOfWords)
    {
        String randomStrings = new String();
        Random random = new Random();


            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings = new String(word);

        return randomStrings;
    }

    static void testPerformance(List<String> keys, Map<String, String>... maps){
        String key;
        Random random = new Random();
        for(Map map : maps) {
            long _start = System.currentTimeMillis();
            for (int i = 0; i < 1_000_000; i++) {
                key = keys.get(random.nextInt(keys.size()));
                map.get(key);

            }
            long _finish = System.currentTimeMillis();
            System.out.println("Time for: " + map.getClass() + " is: " + (_finish - _start) / 1000.0d);
        }

    }

    static List<String> initMaps(Map<String, String> ... maps){
        String randomString;
        Random random = new Random();
        List<String> keys = new ArrayList<>(1000000);

        for(Map m : maps) {
            for (int i = 0; i < 1000000; i++) {
                char[] word = new char[random.nextInt(8) + 3];
                for (int j = 0; j < word.length; j++) {
                    word[j] = (char) ('a' + random.nextInt(26));
                }
                randomString = new String(word);
                keys.add(randomString);
                m.put(randomString, randomString);

            }
        }
        return keys;
    }



    public static void main(String[] args)
    {

        long start = System.currentTimeMillis();

        TextProcessorDataManipulator process = new TextProcessorDataManipulator();
        try {
            process.process();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long finish = System.currentTimeMillis();

        System.out.println((finish - start) / 1000.0 );


        AbstractMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        List<String> keys = new ArrayList<>(1000000);

        keys = initMaps(concurrentHashMap, hashMap, treeMap, linkedHashMap);



        testPerformance(keys, concurrentHashMap, hashMap, treeMap, linkedHashMap);


    }
}
