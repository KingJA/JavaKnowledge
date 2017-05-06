package concurrent.producer_customer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Producer implements Runnable {
    private String producerName;
    private Queue queue;

    public Producer(String producerName, Queue queue) {
        this.producerName = producerName;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {

            Product product = new Product(new Random().nextInt(100));
            queue.put(product);
            System.out.println(producerName + " 【生产产品】 : " + product.getProductNo());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
