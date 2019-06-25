package 代理模式.CGLIB代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * FileName: ProxyTest
 * Author:   qihao
 * Date:     2019/5/29 22:51
 * Version: 1.0
 */
public class ProxyTest implements MethodInterceptor {

    private Object target; // 需要代理的类

    public Object getInstance(Object target){
        this.target = target;  //给业务对象赋值
        Enhancer enhancer = new Enhancer(); // 创建加强类，用来创建动态代理类
        enhancer.setSuperclass(this.target.getClass());  // 指定代理类
        enhancer.setCallback(this); // 调用callback方法，则需要实现intercept方法进行拦截
        System.out.println(" enhancer.setCallback(this)");
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] agrs, MethodProxy methodProxy) throws Throwable {
        System.out.println("预处理方法。。。。");
        methodProxy.invokeSuper(obj, agrs);
        System.out.println("调用后处理。。。。。");
        return null;
    }
}
