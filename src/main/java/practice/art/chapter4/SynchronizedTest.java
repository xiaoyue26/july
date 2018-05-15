package practice.art.chapter4;

/**
 * Created by xiaoyue26 on 18/2/5.
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        synchronized (SynchronizedTest.class) {

        }
        m();
    }

    public static synchronized void m() {
    }
}
