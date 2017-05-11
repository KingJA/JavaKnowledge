package concurrent.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * Description：TODO
 * Create Time：2017/5/9 9:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {

    private static ExecutorService threadPool;

    public static void main(String[] args) {
        threadPool = Executors.newCachedThreadPool();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        Future<Integer> future = (Future<Integer>) threadPool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        try {
            Integer integer = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Integer integer = future.get(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
