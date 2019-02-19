package com.agh;

public class SumOfIntegers {

    public static void main(String[] args) {


            int sum = 0;

            for (String arg : args) {

                try {
                    sum += Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid argument: " + arg + "skipping from sum...");
                }
            }
            System.out.println("sum of args: " + sum);

            int[] outOfBounds = new int[10];
            try{
                for (int i = 0; i < 110; i++) {
                    System.out.println(outOfBounds[i]);
                }
            }catch(IndexOutOfBoundsException ex){
                System.out.println("Index out of bounds");
            }


        }


    }



