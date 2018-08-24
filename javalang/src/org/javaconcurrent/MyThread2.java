package org.javaconcurrent;

import java.util.Random;

/**
 * Created by licheng on 3/19/18.
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int addResult = 0;
        for(int j=0;j<10;j++){
            for(int i=0;i<50000;i++){
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread2 用时：" + (endTime - beginTime) + "毫秒");
    }
}
