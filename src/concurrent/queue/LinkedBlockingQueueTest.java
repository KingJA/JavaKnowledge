package concurrent.queue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("BlockingQueue size:"+queue.size());

        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

//        Iterator<Integer> iterator = queue.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("iterator:"+iterator.next());
//        }

    }
}
