package org.javaconcurrent;

public class Demo2 implements Runnable{
    public static void main(String[] args){
        Demo2 demo2 = new Demo2();
        Thread thread = new Thread(demo2);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("x");
    }
}
