package com.edu.agh;

import java.io.*;

public class Serial<T extends Serializable> implements Serializator{

    public static void serializePerson(String filename){
        Person p = new Person("John", "Smith", 213123321);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializePerson(String filename){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Person p = (Person) in.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        serializePerson("Person.txt");
        deserializePerson("Person.txt");

    }



    @Override
    public void serialize(Serializable object) throws IOException {

    }

    @Override
    public T deserialize(String file) {
        return (T) new Object();
    }
}
