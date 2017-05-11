package concurrent.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/8 10:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class LinkedBlockingDequeTest {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        Producer producer = new Producer(queue);
        Consumer custom = new Consumer(queue);
        producer.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        custom.start();
    }

    static class Producer extends Thread {
        private LinkedBlockingDeque queue;

        public Producer(LinkedBlockingDeque queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("生产数据：" + i);
                    queue.putFirst(i);
                    TimeUnit.MILLISECONDS.sleep(i + 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private LinkedBlockingDeque queue;

        public Consumer(LinkedBlockingDeque queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("消费数据：" + queue.takeLast());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
