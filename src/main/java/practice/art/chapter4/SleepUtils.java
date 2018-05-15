package practice.art.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
