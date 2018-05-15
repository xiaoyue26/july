package practice.art.chapter4;

/**
 * Created by xiaoyue26 on 18/2/3.
 */
public class DaemonTest {
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonRunner print from finally ");
            }
        }
    }


    public static void main(String[] args) {

        Thread thread = new Thread(new DaemonRunner(), "DaemonThread");
        thread.setDaemon(true);
        thread.start();
    }
}
