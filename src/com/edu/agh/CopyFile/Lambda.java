package com.edu.agh.CopyFile;

import com.edu.agh.Person;
import jdk.internal.dynalink.linker.ConversionComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        Person[] persons = {new Person("Jan", "Kowalski", 1), new Person("Adam", "Samsonowicz", 22), new Person("Janek", "Kowal", 2222)};
////
////        Comparator<Person> compA = new Comparator<Person>() {
////            @Override
////            public int compare(Person o1, Person o2) {
////                return o1.getName().compareTo(o2.getName());
////            }
////        };
////        Comparator<Person> compB = new Comparator<Person>() {
////            @Override
////            public int compare(Person o1, Person o2) {
////                return o1.getLastname().compareTo(o2.getLastname());
////            }
////        };
////
////        Comparator<Person> compC = (pa, pb) -> pa.getName().length() - pb.getName().length();
////
////        Arrays.sort(persons, compC);
////        System.out.println(Arrays.toString(persons));
////
////        ComparisonProvider comparisonProvider = new ComparisonProvider();
////
////        Arrays.sort(persons, comparisonProvider::compareByFirstName);
////        System.out.println(Arrays.toString(persons));
////
////        Arrays.sort(persons, ComparisonProvider::compareByLastName);
////        System.out.println(Arrays.toString(persons));

        List<Person> persons2 = Arrays.asList(persons);

        persons2.forEach(System.out::println);
        System.out.println(persons2.stream().filter(p->{
            return p.getLastname().startsWith("Ko");
        }).count());

//        List<Person> ko = persons2.stream().filter(p->p.getLastname().startsWith("Ko")).forEach(System.out::println);

    }
}
