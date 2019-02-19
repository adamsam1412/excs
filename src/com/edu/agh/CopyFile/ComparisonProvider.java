package com.edu.agh.CopyFile;

import com.edu.agh.Person;

public class ComparisonProvider {

    public int compareByFirstName(Person p1, Person p2){
        return p1.getName().compareTo(p2.getName());
    }

    public static int compareByLastName(Person p1, Person p2){
        return p1.getLastname().compareTo(p2.getLastname());
    }
}
