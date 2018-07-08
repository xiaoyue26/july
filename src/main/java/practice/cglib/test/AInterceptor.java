package practice.cglib.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author xiaoyue26
 */
public class AInterceptor implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理实例
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());// 继承传入的对象
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 实现MethodInterceptor接口要重写的方法。
     * 回调方法
     */
    @Override
    public Object intercept(Object obj, Method method
            , Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = proxy.invokeSuper(obj, args);// 调用父类对象(调用原实现)
        System.out.println("事务结束。。。");
        return result;
    }

    public static void main(String[] args) {
        AInterceptor aInterceptor = new AInterceptor();
        AImpl a1 = (AImpl) aInterceptor.getInstance(new AImpl());
        a1.doSomething();
    }


}
