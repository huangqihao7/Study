package 代理模式.CGLIB代理;

/**
 * FileName: Test
 * Author:   qihao
 * Date:     2019/5/29 23:00
 * Version: 1.0
 */
public class Test {


    public static void main(String[] args) {
        ProxyTest proxy = new ProxyTest();
        IUserDao userDao = new UserDao();
        IUserDao obj = (UserDao) proxy.getInstance(userDao);
        obj.find();


        Test test = new Test();
        Test t1 = (Test) proxy.getInstance(test);
        t1.find();
    }


    public void find(){
        System.out.println("find method");
    }
}
