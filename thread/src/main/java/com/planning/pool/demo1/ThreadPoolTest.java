package com.planning.pool.demo1;

import com.planning.utils.ThreadUtils;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * compare ForkJoinPool
 * @author planning
 * @since 2019-10-30 16:57
 **/
public class ThreadPoolTest {

    private double[] d = new double[10001];

    @Test
    public void test() throws ExecutionException, InterruptedException {
        d = ThreadUtils.createArrayOfRandomDoubles();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, Long.MAX_VALUE, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        Future[] futures = new Future[4];
        int size = d.length / 4;
        for (int i = 0; i < 3; i++) {
            futures[i] = executor.submit(new ThreadPoolExecutorTask(i * size, (i + 1)* size -1));
        }
        futures[3] = executor.submit(new ThreadPoolExecutorTask(3 * size, d.length -1));
        int n = 0;
        for (int i = 0; i < 4; i++) {
            n += (int)futures[i].get();
        }
        System.out.println("Found " + n + " values");
    }

    private class ThreadPoolExecutorTask implements Callable<Integer> {
        private int first;
        private int last;
        public ThreadPoolExecutorTask(int first, int last){
            this.first = first;
            this.last = last;
        }

        @Override
        public Integer call() {
            int subCount = 0;
            for (int i = first; i < last; i ++){
                if(d[i] < 0.5){
                    subCount ++;
                }
            }
            return subCount;
        }
    }
}