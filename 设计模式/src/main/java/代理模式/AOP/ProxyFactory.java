package 代理模式.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FileName: ProxyFactory
 * Author:   qihao
 * Date:     2019/5/28 23:11
 * Version: 1.0
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }


    public Object getProxyInstance(){
        Object porxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {

                        // 获取当前执行的方法的方法名
                        String methodName = method.getName();
                        // 方法返回值
                        Object result = null;
                        if ("find".equals(methodName)) {
                            // 直接调用目标对象方法
                            result = method.invoke(target, args);
                        } else {
                            System.out.println("开启事务...");
                            // 执行目标对象方法
                            result = method.invoke(target, args);
                            System.out.println("提交事务...");
                        }
                        return result;
                    }
                });
        return porxy;
    }

}
