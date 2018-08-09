package org.javacore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by licheng on 6/19/18.
 */
public class JavaListDemo {
    public static void main(String args[]){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        List<Number> list = new ArrayList<>(set);
        for (Object o:list.toArray()) {
            System.out.println(o.toString());
        }
        System.out.println(set.toArray().getClass());
        System.out.println(Object[].class);



    }



}
