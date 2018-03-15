package org.javacontainer;

import java.util.*;

/**
 * Created by LICHENG on 2018/1/23.
 */
 class Apple{
     private static long counter;
     private final long id = counter++;
     public long id(){
         return id;
     }
}

class Orange{

}


public class TestSet {

    public static void main(String args[]){
        Collection<Integer> apples = new HashSet<Integer>();
        apples.add(1);
        apples.add(2);
        apples.add(3);

        int size = apples.size();



        for(Integer i:apples){
            System.out.println(i);
        }


        for(int i=0;i<size;i++){
            System.out.println(apples.contains(i));
        }


    }



}
