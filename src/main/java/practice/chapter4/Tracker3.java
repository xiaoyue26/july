package practice.chapter4;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiaoyue26 on 17/9/25.
 *
 * 底层对象是可变,而且线程安全时.
 * 对外发布不可变引用,可以让客户端随便改Point而不用担心有错.锁的粒度也很细,只锁了每个Point对象.
 *
 * 优缺点和Tracker2差不多.多一个Point对象上的锁.少一点Point的存储空间.
 *
 * 锁在Point上.
 */
@ThreadSafe
public class Tracker3 {

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public Tracker3(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);//第一级浅拷贝.
        unmodifiableMap = Collections.unmodifiableMap(locations);// 动态引用.
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;//返回引用
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);//返回引用
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid id: " + id);
        }
        locations.get(id).set(x, y);//直接改了
    }

    @ThreadSafe
    public class SafePoint {//私有构造器捕获模式
        @GuardedBy("this")
        private int x, y;

        public SafePoint(SafePoint p) {
            this(p.get());
        }

        public synchronized int[] get() {//把获取p.x和p.y的操作封装成一个原子操作. 
            return new int[]{x, y};
        }

        public synchronized void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private SafePoint(int[] a) {
            this(a[0], a[1]);
        }

        public SafePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
