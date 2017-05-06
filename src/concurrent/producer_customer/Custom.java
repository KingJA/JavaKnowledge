package concurrent.producer_customer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Custom implements Runnable {
    private Queue queue;


    public Custom(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {

            Product product = queue.take();
            System.out.println(Thread.currentThread().getName() + " [处理产品] : " + product.getProductNo());
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000) + 1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
