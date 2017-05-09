package concurrent.customthreadpool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/9 13:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Task implements Runnable {


    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行任务："+ taskId);
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
