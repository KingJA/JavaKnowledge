package concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/9 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("CPU个数："+Runtime.getRuntime().availableProcessors());
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    System.out.println("Thread Running");
                }
            }
        };
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
