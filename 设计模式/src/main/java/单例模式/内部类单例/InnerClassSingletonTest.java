package 单例模式.内部类单例;

import java.lang.reflect.Constructor;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 17:05
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            Class<?> clazz = InnerClassSingleton.class;
            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问
            c.setAccessible(true);

            Object o1 = c.newInstance();
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
