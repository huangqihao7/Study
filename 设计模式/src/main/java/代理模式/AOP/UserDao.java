package 代理模式.AOP;

/**
 * FileName: UserDao
 * Author:   qihao
 * Date:     2019/5/28 23:07
 * Version: 1.0
 */
public class UserDao implements IUserDao {

    @Override
    public void find() {
        System.out.println("模拟查询数据");
    }

    @Override
    public void insert(String agrs) {
        System.out.println("模拟插入数据 : " + agrs);
    }
}
