package concurrent.threadpool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/9 14:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {

    private static ExecutorService cachedThreadPool;
    private static ExecutorService singleThreadExecutor;
    private static ExecutorService fixedThreadPool;
    private static ScheduledExecutorService scheduledThreadPool;
    private static ScheduledExecutorService singleScheduledThreadPool;

    public static void main(String[] args) {
        cachedThreadPool = Executors.newCachedThreadPool();
        singleThreadExecutor = Executors.newSingleThreadExecutor();
        fixedThreadPool = Executors.newFixedThreadPool(5);
        scheduledThreadPool = Executors.newScheduledThreadPool(5);
        singleScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        doScheduledThreadPool();

    }

    private static void doScheduledThreadPool() {
        //延迟执行(每隔3000毫秒执行1次)
//        scheduledThreadPool.schedule(new Task(), 3000, TimeUnit.MILLISECONDS);
        //延迟,定时执行(1000毫秒后每隔2000毫秒执行1次)
//        scheduledThreadPool.scheduleWithFixedDelay(new Task(),1000,2000,TimeUnit.MILLISECONDS);
        singleScheduledThreadPool.scheduleWithFixedDelay(new Task(),1000,2000,TimeUnit.MILLISECONDS);
    }

    private static void doFixedThreadPool() {
        for (int i = 0; i < 15; i++) {
            fixedThreadPool.execute(new Task());
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doCachedThreadPool() {
        for (int i = 0; i < 20; i++) {
            cachedThreadPool.execute(new Task());
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doSingleThreadExecutor() {
        for (int i = 0; i < 10; i++) {
            singleThreadExecutor.execute(new Task());
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500) + 1750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
