package practice.cglib.test;

/**
 * @author xiaoyue26
 */
public class AImpl {// 并不继承接口,但不是final的(可以有子类)

    public void doSomething() {
        System.out.println("AImpl doSomething");
    }

}
