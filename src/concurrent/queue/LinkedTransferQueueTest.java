package concurrent.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LinkedTransferQueueTest {
    public static void main(String[] args) {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        Producer producer = new Producer(queue);
        Consumer custom = new Consumer(queue);
        producer.start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        custom.start();
    }

    static class Producer extends Thread {
        private LinkedTransferQueue queue;

        public Producer(LinkedTransferQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = new Random().nextInt(5);
                    System.out.println("是否有消费者等待：" + queue.tryTransfer(data,3000,TimeUnit.MILLISECONDS));
                    System.out.println("生产数据：" + data);
//                    queue.transfer(data);
//                    System.out.println("消费完成：" + data);
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500)+500);
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
