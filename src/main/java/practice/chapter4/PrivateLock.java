package practice.chapter4;



import javax.annotation.concurrent.GuardedBy;
import java.util.Collections;

/**
 * Created by xiaoyue26 on 17/9/25.
 * 私有的锁可以让客户代码无法错误得获得锁,使用锁,降低风险.
 */
public class PrivateLock {
    private final Object myLock=new Object();
    @GuardedBy("myLock")
    Person person;
    void someMothode(){
        synchronized (myLock){
            // do some thing
        }
    }
}
