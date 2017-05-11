package concurrent.thread.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/11 11:25
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class GetDataThread extends Thread {
    private DataCenter dataCenter;
    private int dataId;

    public GetDataThread(DataCenter dataCenter, int dataId) {
        super(dataId+"");
        this.dataCenter = dataCenter;
        this.dataId = dataId;
    }

    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"第一次取出数据 "+dataCenter.get());
        System.out.println("线程"+Thread.currentThread().getName()+"存入数据 "+dataId);
        dataCenter.put(dataId);
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"取出数据 "+dataCenter.get());
    }
}
