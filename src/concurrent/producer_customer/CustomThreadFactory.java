package concurrent.producer_customer;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CustomThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, Constants.CUSTOMS[new Random().nextInt( Constants.CUSTOMS.length)]);
    }
}
