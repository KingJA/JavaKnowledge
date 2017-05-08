package concurrent.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        Producer producer = new Producer(queue);
        Consumer custom = new Consumer(queue);
        producer.start();
        custom.start();
    }

    static class Producer extends Thread {
        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = new Random().nextInt(5);
                    queue.put(data);
                    System.out.println("生产数据：" + data);
                    System.out.println("加入数据后队列长度：" + queue.size());
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000)+2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("消费数据："+queue.take());
                    System.out.println("消费数据后队列长度：" + queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
