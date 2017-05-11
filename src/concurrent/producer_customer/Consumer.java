package concurrent.producer_customer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Consumer extends Thread {
    private int totleTask;
    private BlockingDeque<Product> queue;

    public Consumer(BlockingDeque<Product> queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Product product = queue.take();
                System.out.println("---消费产品     【产品ID : " + product.getProductNo() + "】【总消费产品数 : " + (++totleTask) + "】");
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
