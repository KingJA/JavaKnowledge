package concurrent.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Description：TODO
 * Create Time：2017/5/8 13:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DelayAction implements Delayed {
    private int id;
    private long expire;

    public DelayAction(int id, long delay) {
        this.id = id;
        expire = System.currentTimeMillis() + delay;    //到期时间 = 当前时间+延迟时间
    }

    public int getId() {
        return id;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS));
    }
}
