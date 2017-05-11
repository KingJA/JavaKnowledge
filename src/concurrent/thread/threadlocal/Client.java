package concurrent.thread.threadlocal;

/**
 * Description：TODO
 * Create Time：2017/5/11 11:25
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        for (int i = 0; i < 5; i++) {
            new GetDataThread(dataCenter,i).start();
        }
    }
}
