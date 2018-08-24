package org.javaconcurrent;

/**
 * Created by licheng on 3/19/18.
 */
public class Run {
    public static void main(String args[]) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        threadA.start();
        ThreadB threadB = new ThreadB(num);
        threadB.start();
    }
}
