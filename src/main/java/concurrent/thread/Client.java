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
        WorkThread thread = new WorkThread();
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.quit();
    }
    static class WorkThread extends Thread{
        private boolean mQuit;
        @Override
        public void run() {
            while (true) {
                System.out.println("running");
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("stop");
                    if (mQuit) {
                        System.out.println("quit");
                        return;
                    }
                }
            }
        }
        public void quit() {
            mQuit = true;
            interrupt();
        }
    }
}
