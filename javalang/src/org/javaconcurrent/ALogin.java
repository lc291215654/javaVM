package org.javaconcurrent;

/**
 * Created by licheng on 3/19/18.
 */
public class ALogin extends Thread{

    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a","aa");
    }
}
