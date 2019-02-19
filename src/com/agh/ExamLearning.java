package com.agh;

import java.util.*;

public class ExamLearning<T extends Comparable>{


    Set<T> set1 = new HashSet<>();
    Set<T> set2 = new HashSet<>();



    public static <T>Set intersection(Set<T> set1, Set<T> set2) {

        Iterator iterator = set1.iterator();
        Iterator iterator1 = set2.iterator();
        Set<T> result = new HashSet<>();
        while(iterator.hasNext()){
            T e1 = (T)iterator.next();
            if(set2.contains(e1)){
                result.add(e1);
            }
        }


        return result;

    }


    public static  <K, V>Map mapIntersection(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> result = new HashMap<>();

        for(Map.Entry<K, V> entry : map1.entrySet()){
            K key = entry.getKey();
            if(map2.containsKey(key)) result.put(key, (V)"Default Value");

        }
        return result;
    }

    public static void main(String[] args) {

        Set<String> test1 = new HashSet<>();
        Set<String> test2 = new HashSet<>();

        test1.add("A");
        test1.add("B");
        test1.add("C");
        test2.add("C");
        test2.add("D");

        Set<String> result = intersection(test1, test2);

        Iterator iterator = test1.iterator();
        Iterator iterator1 = test2.iterator();
        Iterator iterator2 = result.iterator();

        while(iterator.hasNext()){
            String e = (String)iterator.next();
            System.out.println(e);
        }

        while(iterator1.hasNext()){
            String e = (String)iterator1.next();
            System.out.println(e);
        }

        while(iterator2.hasNext()){
            String e = (String)iterator2.next();
            System.out.println(e);
        }

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> resultMap = new HashMap<>();


        map1.put("A", "A");
        map1.put("B", "B");
        map2.put("A", "A");
        map2.put("C", "C");

        resultMap = mapIntersection(map1, map2);

        for(Map.Entry<String, String> entry : map1.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }

        for(Map.Entry<String, String> entry : map2.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }

        for(Map.Entry<String, String> entry : resultMap.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }




    }

}
