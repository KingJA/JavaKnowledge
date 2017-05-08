package concurrent.queue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
       BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("ArrayBlockingQueue size:"+queue.size());

        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

//        Iterator<Integer> iterator = queue.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("iterator:"+iterator.next());
//        }

    }
}
