package concurrent.producer_customer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:07
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Thread producerThread = new Thread(new Producer("张三", queue));
        producerThread.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <1; i++) {
            executorService.execute(new Custom(queue));
        }


    }
}
