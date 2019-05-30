package 代理模式.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * FileName: Test
 * Author:   qihao
 * Date:     2019/5/29 0:03
 * Version: 1.0
 */
public class Test {

//    ApplicationContext ac =  new ClassPathXmlApplicationContext("application.xml");
    ApplicationContext ac =  new ClassPathXmlApplicationContext("file:D:\\workSoftware\\ideaworkspace\\Study\\设计模式\\src\\main\\java\\代理模式\\AOP\\application.xml");

    public static void main(String[] args) {
        new Test().test();
    }

    public void test(){
        IUserDao userDao = (IUserDao) ac.getBean("userDao");

        userDao.insert("测试");
    }

}
