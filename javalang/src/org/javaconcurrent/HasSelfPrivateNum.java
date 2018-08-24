package org.javaconcurrent;

/**
 * Created by licheng on 4/10/18.
 */
public class HasSelfPrivateNum {
    private int num = 0;
    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }
    @Override
    public void run(){
        super.run();
        numRef.addI("a");
    }
}

class ThreadB extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }
    @Override
    public void run(){
        super.run();
        numRef.addI("b");
    }
}
