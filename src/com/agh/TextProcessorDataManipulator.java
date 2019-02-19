package com.agh;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextProcessorDataManipulator<K, V> extends TextProcessorBase {


    @Override
    public void processData() {
        dataFrequency(words);
        topFrequent(30, true);
        performanceTest();
    }


    private Map<String, Integer> dataFrequency(List<String> listOfWords) {

        for (String word : listOfWords) {
            if (histogram.containsKey(word))
                histogram.replace(word, histogram.get(word) + 1);
            else {
                histogram.put(word, 1);
            }
        }

        return histogram;
    }

    private <String, Integer extends Comparable<? super Integer>>
    Map<String, Integer> sortByValue(Map<String, Integer> map) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());

        }
        return result;
    }

    private void topFrequent(int top) {

        Map<String, Integer> topFreqeunt;
        topFreqeunt = sortByValue(histogram);
        int counter = 0;
        for (Map.Entry<String, Integer> entry : topFreqeunt.entrySet()) {
            if (counter > top) break;
            resultTopFrequentMap.put(entry.getKey(), entry.getValue());
            counter++;
        }
    }

    public void topFrequent(int top, boolean newVersion) {
        if (!newVersion) {
            topFrequent(top);
            return;
        }

        Map<String, Integer> topFreqeunt =
                histogram.entrySet().stream().
                        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                        limit(top).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> entry : topFreqeunt.entrySet())
            resultTopFrequentMap.put(entry.getKey(), entry.getValue());
    }

    public void performanceTest() {
        Random random = new Random();
        List<String> keys = new ArrayList<String>(histogram.keySet());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 6000; i++) {

            String randomKey = keys.get(random.nextInt(keys.size()));
            System.out.println(histogram.get(randomKey));
        }
        long finish = System.currentTimeMillis();

        System.out.println("Accessing random elements: " + (finish - start) / 1000.0d);

    }


}
