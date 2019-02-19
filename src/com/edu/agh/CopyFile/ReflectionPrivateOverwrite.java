package com.edu.agh.CopyFile;

import com.edu.agh.Person;

import java.lang.reflect.Field;
import java.nio.file.NoSuchFileException;

public class ReflectionPrivateOverwrite {

    public static void main(String[] args){
        Person person = new Person("Jan", "Kowal", 12);

        try{
            Field field = person.getClass().getDeclaredField("lastname");

            field.setAccessible(true);

            System.out.println("LastName = " + field.get(person));
            field.set(person, "Nowak");
            System.out.println("LastName = " + person.getLastname());


        }catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e){
            e.printStackTrace();
        }

    }





}
