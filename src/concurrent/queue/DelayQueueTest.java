package concurrent.queue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        BlockingQueue<DelayAction> queue = new DelayQueue<>();
        try {
            queue.put(new DelayAction(1, 5000));
            queue.put(new DelayAction(3, 3000));
            queue.put(new DelayAction(2, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PriorityBlockingQueue  size:" + queue.size());
        for (Iterator iterator = queue.iterator(); iterator.hasNext(); ) {
            try {
                System.out.println(queue.take().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
