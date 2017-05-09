package concurrent.customthreadpool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/9 11:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2, 3, 30000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), new CustomThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 100; i++) {
            customThreadPool.execute(new Task(i));
        }
        try {
            TimeUnit.MILLISECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeThreadPool(customThreadPool);

    }

    private static void closeThreadPool(CustomThreadPool customThreadPool) {
        //关闭线程池
        List<Runnable> runnables = customThreadPool.shutdownNow();
        System.out.println(runnables.size());
    }
}
