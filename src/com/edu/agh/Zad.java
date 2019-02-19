package com.edu.agh;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zad<K, V> {

    public static <K extends Serializable>Map<K, Integer> histogram(List<K> list){
        Map<K, Integer> map = new HashMap<>();
        for(K key : list){
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }

        }
        return map;
    }

    public static Map<Serializable, Integer> histogramB(List<? extends Serializable> list){
        Map<Serializable, Integer> map = new HashMap<>();
        for(Serializable key : list){
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        return map;
    }

    public static void main(String[] args){
        List<Person> ppl = Arrays.asList(new Person("John", "Smith", 1), new Person("John", "Smith", 1), new Person("John", "Smith", 1));
        Map<? extends Serializable, Integer> map = histogramB(ppl);
        for(Map.Entry<? extends Serializable, Integer> p : map.entrySet()){
            System.out.println(p.getKey() + ": " + p.getValue());
        }
    }




}
