package org.javaconcurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by licheng on 3/15/18.
 */
public class ConditionTest {
    public static void main(String args[]) {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        BlockingQueue blockingQueue;

    }
}
