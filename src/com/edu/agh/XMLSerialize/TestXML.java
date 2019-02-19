package com.edu.agh.XMLSerialize;

import com.edu.agh.Person;

public class TestXML {


    public static void main(String[] args){
        Person person = new Person("Jan", "Kowalski", 123);

        XMLSerializer.processObject(person);
    }
}
