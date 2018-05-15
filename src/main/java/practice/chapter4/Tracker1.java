package practice.chapter4;

//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyue26 on 17/9/25.
 * <p>
 * 在可变对象上组合线程安全的对象.
 * 因为底层对象是可变的,所以不能对外发布引用,只能发布镜像.
 *
 * 缺点: (1)deepCopy锁定开销太大.
 *      (2)无法返回动态引用,没有实时性.
 *      (3)频繁做静态镜像,内存开销大.
 *      (4)锁粒度大,加在Tracker上.
 * 优点:
 * (1) 对底层对象要求低,可变都行.
 */
@ThreadSafe
public class Tracker1 {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;//对外发布和内部使用的都是不可变的. 修改通过MutablePoint的可变完成.

    public Tracker1(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);//返回一个深拷贝. 静态镜像
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);//返回一个深拷贝. 静态镜像
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }


    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> res = new HashMap<>();
        for (String id : m.keySet()) {
            res.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(res);
    }


    public static class MutablePoint {
        public int x, y;

        public MutablePoint() {
            x = 0;
            y = 0;
        }

        public MutablePoint(MutablePoint p) {
            x = p.x;
            y = p.y;
        }
    }

    public static void main(String[]args){
        String value="userid ] ";
        StringUtils.stripEnd(value," ] ");
        //System.out.println(StringUtils.stripEnd(value," ]"));


    }
}
