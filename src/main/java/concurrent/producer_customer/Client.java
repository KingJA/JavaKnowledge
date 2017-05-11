package concurrent.producer_customer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:07
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {

    public static void main(String[] args) {
        BlockingDeque<Product> queue = new LinkedBlockingDeque<>();
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
