package practice.chapter2;

// import org.apache.http.annotation.ThreadSafe;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by xiaoyue26 on 17/9/24.
 */
@ThreadSafe
public class AtomicLongTest {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }


    public static void main(String[] args) {
        AtomicLongTest at = new AtomicLongTest();
        System.out.println(at.getCount());
    }

}
