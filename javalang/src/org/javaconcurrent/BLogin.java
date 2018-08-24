package org.javaconcurrent;

/**
 * Created by licheng on 3/19/18.
 */
public class BLogin extends Thread{

    @Override
    public void run() {
        super.run();
        Thread t1 = Thread.currentThread();
        StackTraceElement[] stackTraceElements = t1.getStackTrace();
        for (int i=0;i<stackTraceElements.length;i++){
            System.out.println(stackTraceElements[i]);
        }
        t1.interrupt();
        LoginServlet.doPost("b","bb");
    }
}
