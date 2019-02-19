package com.edu.agh.CopyFile;

import com.edu.agh.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {

    public void filterFiles(){
        Path dir = Paths.get(".");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")){
            for(Path p : stream){
                System.out.println(p.getFileName());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printMethods(){
        for(Method method : String.class.getMethods()){
            System.out.println(method.getReturnType().getSimpleName() + " " + method.getName() + " (");
            Class<?>[] cs = method.getParameterTypes();
            for(int i = 0; i < cs.length; i++){
                System.out.println(cs[i].getSimpleName());
                if(i < cs.length - 1)
                    System.out.println(", ");
            }
            System.out.println(")");
        }

    }

    public static void main(String[] args){
        ListFiles txtList = new ListFiles();
        txtList.filterFiles();

        Method[] methods = String.class.getMethods();
        for(Method m : methods){
            System.out.println(m.getName() + "<---Methods in class");
        }

        ListFiles lf = new ListFiles();
        lf.printMethods();

        Class cs = Person.class;
        Field[] fields = cs.getFields();





    }
}



