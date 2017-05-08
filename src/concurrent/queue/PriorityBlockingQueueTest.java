package concurrent.queue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        try {
            queue.put(1);
            queue.put(3);
            queue.put(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PriorityBlockingQueue  size:"+queue.size());

        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(queue.remove());

        }

//        Iterator<Integer> iterator = queue.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("iterator:"+iterator.next());
//        }

    }
}
