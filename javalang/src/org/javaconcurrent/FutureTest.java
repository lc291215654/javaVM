package org.javaconcurrent;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * Created by licheng on 3/14/18.
 */
public class FutureTest {
    public static ThreadPoolExecutor threadsPool;

    public static void main(String args[]) {

//        FutureTask futureTask = new FutureTask();

        int corePoolSize = Runtime.getRuntime().availableProcessors();
        init(corePoolSize);
        Future<HashMap<String, String>> result = getDataFromRemote2();



        try {
            System.out.println("two");
            Thread.sleep(1000);
            System.out.println("two");
            Thread.sleep(1000);
            System.out.println("two");
            Thread.sleep(1000);
            System.out.println("two");
            HashMap<String, String> resultHashMap = result.get();
            System.out.println(resultHashMap.get("one"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("two");

    }

    public static void init(int corePoolSize) {
        threadsPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 10l, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000));
    }

    private static Future<HashMap<String, String>> getDataFromRemote2() {
        return threadsPool.submit(new Callable<HashMap<String, String>>() {
            public HashMap<String, String> call() throws Exception {
                return getDataFromRemote();
            }
        });
    }

    private static HashMap<String, String> getDataFromRemote() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("one","one word!");

        return result;
    }
}
