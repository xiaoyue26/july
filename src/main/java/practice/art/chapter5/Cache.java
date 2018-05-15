package practice.art.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {

            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    public volatile boolean update = false;

    // 锁降级案例
    public void processData() {
        r.lock();
        if (!update) {
            r.unlock();
            // 1. 获取写锁
            w.lock();
            try {
                if (!update) { // 双检,update状态可能又变化了
                    // do something
                    // 2. 写数据
                    update = true;
                }
                r.lock(); // 3. 获取读锁
            } finally {
                w.unlock(); // 4. 释放写锁（锁降级完成,写锁变成了读锁）
            }
        }
        try {
            // do something
            // 5. 读数据
        } finally {
            r.unlock(); // 6. 读锁最终释放
        }
    }

    public static void main(String[] args) {
        Cache obj = new Cache();
        System.out.println("there");
        // LockSupport.park();
    }
}