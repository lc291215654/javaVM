package org.javaconcurrent.roocon;

import java.util.concurrent.*;

public class Demo5 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call was exe!");
        Thread.sleep(5000);
        return "success";
    }

    public static void main(String[] args){
        FutureTask futureTask = new FutureTask<>(new Demo5());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(System.currentTimeMillis());
            System.out.println(futureTask.get(6000, TimeUnit.MILLISECONDS));
            System.out.println(System.currentTimeMillis());
            System.out.println(futureTask.get());
            System.out.println(futureTask.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
