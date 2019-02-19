package com.edu.agh.Study;

import com.edu.agh.City;
import com.edu.agh.Person;

import com.edu.agh.Study.Comparator;

import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStudy {







    public static void main(String args[]){


//        //exam exercises
//
//        List<String> list = new ArrayList<>();
//        list.add("STRIN");
//        list.add("STRI");
//        list.add("STRING");
//        list.add("STRING1");
//
//        list.forEach(s->System.out.println(s.length()));
//
//        System.out.println(list.stream().map(s->s.length()).collect(Collectors.toList()));
//
//        Map<String, String>  map = new HashMap<>();
//        map.put("94141209499","Adam");
//        map.put("84141209499","Adam");
//        map.put("85141209412","Adam");
//        map.put("85141209423","Paweł");
//        map.put("85141209433","Jakub");
//
////        List<Map.Entry<String, String>> list2 =
//        String m =  map.entrySet()
//                .stream()
//                .filter(x -> x.getKey().startsWith("85"))
//                .sorted((m1, m2) -> m1.getValue().compareTo(m2.getValue()))
//                .collect(Collectors.toList())
//                .get(0).getValue();
//
//        System.out.println(m + "RESULT");
//
//        map.entrySet().forEach(System.out::println);
//
//        map.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
//
//        for(Map.Entry<String, String> e : map.entrySet()) System.out.println(e);
//
//
//        List<Integer> listToFilter = new ArrayList<>();
//        listToFilter.add(3);
//        listToFilter.add(4);
//        listToFilter.add(5);
//        listToFilter.add(8);
//        listToFilter.add(12);
//        listToFilter.add(7);
//
//
//        Integer sumed = listToFilter.stream()
//                .filter(x -> {
//            return x % 3 == 0 || x % 7 == 0;
//        })
//                .mapToInt(i -> i.intValue()).sum();
//        System.out.println(sumed + " <- sumed");
//
//
//
//
//
//
//
//        Comparator<String> comparator = new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        };
//
//        Comparator<String> comparator1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
//
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                while (i++ < 10) {
//                    System.out.println("OK!");
//                }
//            }
//        };
//
//        Runnable r1 = () -> {
//            int i = 0;
//            while (i++ < 10) {
//                System.out.println("OK!");
//            }
//        };
//
//        Function<Person, Integer> f = person -> person.getId();
//        Function<Person, String> f1 = Person::getLastname;
//
//        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
//        BinaryOperator<Integer> sum1 = (i1, i2) -> Integer.sum(i1, i2);
//        BinaryOperator<Integer> sum2 = Integer::sum;
//
//        Consumer<String> printer = s -> System.out.println(s);
//        Consumer<String> printer1 = System.out::println;
//
//
//
//        String test = "test";
//        printer.accept(test);
//        Integer x = sum.apply(1,2);
//        printer1.accept(x.toString());
//
//
//
//        Comparator<Person> cmpId = (p1, p2) -> p2.getId() - p1.getId();
//        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getName().compareTo(p2.getName());
//        Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastname().compareTo(p2.getLastname());
//
//        Function<Person, Integer> fId = p-> p.getId();
//        Function<Person, String> fName = p->p.getName();
//        Function<Person, String> fLName = p->p.getLastname();
//
//        Comparator<Person> cmpPerson = Comparator.comparing(Person::getId);
//        Comparator<Person> cmpPersonName = Comparator.comparing(Person::getName);
//
//        printer.accept(String.valueOf(cmpPerson.compare(new Person("name", "surname", 1), new Person("name", "surname1", 1))));
//
//        Comparator<Person> comparatorPerson = cmpPerson.thenComparing(cmpPersonName);
//
//        Comparator<Person> cmp = Comparator.comparing(Person::getLastname)
//                                            .thenComparing(Person::getName)
//                                            .thenComparing(Person::getId);
//
//        // PART2
//
//        Predicate<String> p1 = s -> s.length() < 20;
//        Predicate<String> p2 = s -> s.length() > 5;
//        Predicate<String> p3 = p1.and(p2);
//
//        System.out.println("P3 for YES:" + p3.test("YES"));
//        System.out.println("P3 for Good Morning:" + p3.test("Good Morning"));
//        System.out.println("P3 for Good Morning Gentlemen:" + p3.test("Good Morning Gentlemen"));
//
//        Predicate<String> p4 = p1.or(p2);
//
//        System.out.println("P4 for YES:" + p4.test("YES"));
//        System.out.println("P4 for Good Morning:" + p4.test("Good Morning"));
//        System.out.println("P4 for Good Morning Gentlemen:" + p4.test("Good Morning Gentlemen"));
//
//
//        Predicate<String> p5 = Predicate.isEqualsTo("Yes");
//
//        System.out.println("P5 for YES:" + p5.test("Yes"));
//        System.out.println("P5 for Good Morning" + p5.test("Good Morning"));
//
//
//        //PART3

//        Map<String, List<Person>> map1 = new HashMap<>();
//        Map<String, List<Person>> map2 = new HashMap<>();
//
//        map2.forEach(
//                (key, value) ->
//                        map1.merge(
//                                key, value,
//                                (existingPeople, newPeople) -> {
//                                    existingPeople.addAll(newPeople);
//                                    return existingPeople;
//                                }
//                        )
//        );

//        Person person3 = new Person("Paweł", "Kowalski", 4);
//        Person person4 = new Person("Mieszko", "Kowalski", 5);
//        Person person = new Person("Jan", "Kowalski", 1);
//        Person person1 = new Person("Richard", "Kowalski", 2);
//        Person person2 = new Person("Ryszard", "Kowalski", 3);
//        Person person5 = new Person("Wincenty", "Kowalski", 6);
//
//        City newYork = new City("New York");
//        City warsaw = new City("Warsaw");
//        City cracow = new City("Cracow");
//
//        Map<City, List<Person>> map1 = new HashMap<>();
//
//
//        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(person1);
//        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(person5);
//        map1.computeIfAbsent(warsaw, city -> new ArrayList<>()).add(person);
//
//        System.out.println("MAP1");
//        map1.forEach(((city, people) -> System.out.println(city + " = " + people)));
//
//        Map<City, List<Person>> map2 = new HashMap<>();
//
//        map2.computeIfAbsent(newYork, city -> new ArrayList<>()).add(person2);
//        map2.computeIfAbsent(cracow, city -> new ArrayList<>()).add(person3);
//        map2.computeIfAbsent(cracow, city -> new ArrayList<>()).add(person4);
//
//        System.out.println("MAP2");
//        map2.forEach(((city, people) -> System.out.println(city + " = " + people)));
//
//
//
//        System.out.println("MAP: ");
//
//        List<Person> collected = map2.values().stream()
//                .map(x -> {
//                    System.out.println(x.iterator().next());
//
//                  return x.stream().map(p -> Person::new);
//                })
//                .filter(f -> f.getId() > 3)
//                .collect(Collectors.toList());
//
//
//        collected.forEach(System.out::println);
//
//
//
//        Comparator<Person> cmp = Comparator.comparing(Person::getId);










    }






































}
