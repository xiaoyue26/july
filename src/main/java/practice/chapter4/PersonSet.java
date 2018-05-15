package practice.chapter4;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyue26 on 17/9/25.
 * personSet是安全的,但它里头的person不一定是安全的.
 * 假如person有引用逸出,则可能不安全.本例中没有逸出,因此安全.
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this") // 可变对象的安全发布
    private final Set<Person> personSet = new HashSet<>();

    //可变对象的安全使用(在访问路径上同步)
    public synchronized void addPerson(Person p) {
        personSet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return personSet.contains(p);
    }
}
