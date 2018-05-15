package practice.art.chapter4;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class Waiting implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
