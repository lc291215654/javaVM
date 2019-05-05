package org.javaconcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockerTest {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args){
        LockerTest lockerTest = new LockerTest();
        lockerTest.fun1();
    }

    public void fun1(){
        try {
            lock.lock();
            condition.await(1, TimeUnit.SECONDS);
            System.out.println("aa");
        } catch (InterruptedException e) {

        }


    }
}