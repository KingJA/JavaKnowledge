package concurrent.producer_customer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Producer extends Thread {
    private BlockingDeque queue;

    public Producer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int totleTaskCount = 5;
        for (int i = 0; i < totleTaskCount; i++) {
            Product product = new Product(new Random().nextInt(10));
            System.out.println("+++生产产品     【产品ID : " + product.getProductNo()+"】【总生产产品数 : "+(i+1)+"】");
            try {
                queue.put(product);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
