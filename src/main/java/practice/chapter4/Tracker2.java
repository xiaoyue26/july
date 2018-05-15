package practice.chapter4;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xiaoyue26 on 17/9/25.
 * 不可变对象上架构的线程安全对象.
 * 因为底层是不可变对象,所以可以对外发布引用,但需要是不可变引用.
 *
 * 优点:
 * (1) 可静态,可动态,很灵活;
 * (2) 存储开销小;
 * (3) 性能高,不需要太多锁. 锁在map各段上.空间换时间.
 *
 * 缺点:
 * (1) 需要底层对象是不可变的.
 */
@ThreadSafe
public class Tracker2 {

    private final ConcurrentMap<String, Point> locations;//内部使用这个可变的.
    private final Map<String, Point> unmodifiableMap;//对外发布不可变的.

    public Tracker2(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);//把每个key,value放入. 由于String,Point都不可变,因此是浅拷贝也没关系.
        unmodifiableMap = Collections.unmodifiableMap(locations);// 包装,浅拷贝
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;//动态
        // 静态:
        //return Collections.unmodifiableMap(new HashMap<>(locations));// 静态拷贝,某一瞬间的镜像.//深拷贝
    }

    public Point getLocation(String id) {
        return locations.get(id);//因为Point不可变,因此安全. 静态镜像. 会被replace替换.
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {//更改位置为new Point
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }


    @Immutable
    public static class Point {
        public final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
