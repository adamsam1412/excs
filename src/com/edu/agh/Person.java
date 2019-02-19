package com.edu.agh;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{

    String name = "";
    String lastname = "";
    int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, String suername, int id) {
        this.name = name;
        this.lastname = suername;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, lastname, id);
    }

}
