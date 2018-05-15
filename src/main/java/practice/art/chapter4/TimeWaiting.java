package practice.art.chapter4;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class TimeWaiting implements Runnable {

    @Override
    public void run() {
        while (true) {
            SleepUtils.second(100);
        }
    }
}
