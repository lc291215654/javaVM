package org.javaconcurrent;

/**
 * Created by licheng on 3/16/18.
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable tr = new TestRunnable();
        Thread th1 = new Thread(tr);
        th1.start(); //开始执行分线程
//        while(true){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th1.interrupt();  //中断这个分线程
        System.out.println(Thread.currentThread().getState());
//        }
    }
}

//中断一个被阻塞的线程代码
class TestRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(1); //这个线程将被阻塞1000秒
            while (true){
                System.out.println(Thread.currentThread().isInterrupted());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
