package org.javamemory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LICHENG on 2018/1/25.
 */
public class Main {
    static class OOMObject {
    }
    private int stackLength = 1;

    public static void main(String args[]) {

        Main oom = new Main();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }



    }

    public void stackLeak(){
        stackLength++ ;
        stackLeak();
    }

    private static void heapOutOfMemory() {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
