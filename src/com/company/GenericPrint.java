package com.company;

public class GenericPrint {
    public static <T> void printArray(T[] first){
        for(T random : first)
            System.out.println(random);
    }
    public static void main(String args[]){
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };

        printArray( intArray  );
        printArray( stringArray );

        if(GenericPrint.class.getDeclaredMethods().length > 2){
            System.out.println("You should only have 1 method named printArray.");
        }
    }
}

