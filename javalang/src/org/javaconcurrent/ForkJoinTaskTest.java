package org.javaconcurrent;

import java.util.concurrent.RecursiveTask;

/**
 * Created by licheng on 3/14/18.
 */
public class ForkJoinTaskTest extends RecursiveTask<String> {
    private static final int THRESHOLD = 2;//阈值
    private int start;
    private int end;

    public ForkJoinTaskTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected String compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute) {
            for(int i =start; i <=end; i++) {
                sum += i;
            }
        }else {
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start+end) / 2;

        }
        return null;
    }
}
