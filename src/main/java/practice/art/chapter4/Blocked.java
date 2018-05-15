package practice.art.chapter4;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class Blocked implements Runnable {
    @Override
    public void run() {
        synchronized (Blocked.class) {
            while (true) {
                SleepUtils.second(100);
            }
        }

    }
}
