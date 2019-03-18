package org.javaconcurrent.roocon;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo6{

    public static void main(String[] args) throws InterruptedException {

        List<Integer>  values = Arrays.asList(10,20,30,40);
        values.parallelStream().map(i -> i + 5).forEach(System.out :: println);
       ExecutorService executor = Executors.newCachedThreadPool();
       for(int i=0;i<1000;i++){
           System.out.println(" submit " + i);
           executor.execute(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName());
                   try {
                       Thread.sleep(4000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           });
       }
       executor.shutdown();
    }
}
