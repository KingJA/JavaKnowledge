package concurrent.customthreadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Description：自定义线程池
 * Create Time：2017/5/9 11:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CustomThreadPool extends ThreadPoolExecutor {
    private Map<Integer, Long> costTimeMap = new HashMap<>();//每个任务执行时间 <HashCode,Millis>

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public CustomThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        costTimeMap.put(r.hashCode(),System.currentTimeMillis());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("线程池需要中行的任务数："+getTaskCount());
        System.out.println("线程池完成的任务数："+getCompletedTaskCount());
        System.out.println("线程池曾经创建的最大线程数："+getLargestPoolSize());
        System.out.println("线程池线程数："+getPoolSize());
        System.out.println("线程池活动线程数："+getActiveCount());
        costTimeMap.put(r.hashCode(),System.currentTimeMillis()- costTimeMap.get(r.hashCode()));
    }

    @Override
    protected void terminated() {
        super.terminated();
        Set<Map.Entry<Integer, Long>> entries = costTimeMap.entrySet();
        System.out.println("执行的任务数："+entries.size());
        for (Map.Entry<Integer, Long> entry : entries) {
            System.out.println("任务HashCode："+entry.getKey()+"耗时："+entry.getValue());
        }
    }
}
