package concurrent.producer_customer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Queue {
    private BlockingDeque<Product> deque = new LinkedBlockingDeque<>(5);

    public void put(Product product) {
        try {
            deque.put(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Product take() {
        Product product = null;
        try {
            product = deque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean isEmpty() {
        return deque.size() == 0;
    }
}
