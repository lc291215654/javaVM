package org.javaconcurrent;

/**
 * Created by licheng on 3/19/18.
 */
public class CountOperate extends Thread{
    public CountOperate(){
        this.setName("my name!");
    }
    @Override
    public void run(){
        System.out.println("run----begin"+
        this.isAlive());

    }
}
