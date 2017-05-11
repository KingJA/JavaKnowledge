package concurrent.thread.threadlocal;

/**
 * Description：TODO
 * Create Time：2017/5/11 11:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DataCenter {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return -1;
        }
    };

    public void put(int dataId) {
        threadLocal.set(dataId);
    }

    public Integer get() {
        return threadLocal.get();
    }
}
