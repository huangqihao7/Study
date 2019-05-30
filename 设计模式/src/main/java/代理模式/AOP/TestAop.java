package 代理模式.AOP;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * FileName: TestAop
 * Author:   qihao
 * Date:     2019/5/29 0:01
 * Version: 1.0
 */
public class TestAop {

    public void arroud(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置。。。。");
        pjp.proceed();
        System.out.println("环绕后置。。。。");
    }

    public void beginTransaction() {
        System.out.println("开启事务。。。。");
    }

    public void commit() {
        System.out.println("提交事务。。。。");
    }

    public void afterReturing() {
        System.out.println("返回后通知。。。。");
    }

    public void afterThrowing() {

    }
}
