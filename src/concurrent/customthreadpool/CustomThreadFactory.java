package concurrent.customthreadpool;

import java.util.concurrent.ThreadFactory;

/**
 * Description：TODO
 * Create Time：2017/5/9 11:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
