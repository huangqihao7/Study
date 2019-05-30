package 代理模式.动态代理;

/**
 * FileName: Test
 * Author:   qihao
 * Date:     2019/5/28 23:25
 * Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();

        IUserDao proxy = (IUserDao)new ProxyFactory(userDao).getProxyInstance();


        proxy.insert("测试数据111");
    }
}
