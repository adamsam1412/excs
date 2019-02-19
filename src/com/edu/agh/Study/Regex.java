package com.edu.agh.Study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {


    public static void main(String... args){

//        String input = "User password=24321, Some more text password=1234. This clientNum=100";
//
//        Pattern p = Pattern.compile("(password=)(\\d+)");
//        Matcher m = p.matcher(input);
//
//        StringBuffer result = new StringBuffer();
//
//        while(m.find()){
//
//            System.out.println("Group 1: " + m.group(1));
//            System.out.println("Group 2: " + m.group(2));
//
//            m.appendReplacement(result, m.group(1) + "******");
//
//
//        }
//        m.appendTail(result);
//
//        System.out.println(result);


        final String REGEX = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";


        String dateFormat = "31-11-2019";

        Pattern pattern = Pattern.compile(REGEX);

        Matcher matcher = pattern.matcher(dateFormat);

        if(Pattern.matches(REGEX, dateFormat))
            System.out.println("correct");

        if(matcher.matches()) System.out.println("correct format");
        else System.out.println("false");








    }
}
