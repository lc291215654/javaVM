package org.javaconcurrent.roocon;

public class Demo7 {
    private static int value;

    public static int getValue(){
        synchronized(Demo7.class) {
            return value++;
        }
    }

    public static void main(String[] args){

    }

}
