package practice.art.chapter5;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ParkWithBlockerTest {
    public static class UnparkerAndReciever extends Thread {
        Thread main;

        UnparkerAndReciever(Thread main) {
            this.main = main;
        }
        private void sleep(int secends){
            try {
                TimeUnit.SECONDS.sleep(secends);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            sleep(1);
            LockSupport.unpark(main);
            sleep(1); // 注释此行则出现结果1

            Object blocker = LockSupport.getBlocker(main);
            if (blocker != null && blocker instanceof String) {
                System.out.println(blocker); // 结果1
            }
            else{
                System.out.println("blocker=null or not a String"); // 结果2
            }


        }
    }

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        UnparkerAndReciever unparkerAndReciever = new UnparkerAndReciever(mainThread);
        unparkerAndReciever.start();
        LockSupport.park("string in park");
    }


}