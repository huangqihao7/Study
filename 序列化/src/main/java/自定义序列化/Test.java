package 自定义序列化;

/**
 * FileName: Test
 * Author:   qihao
 * Date:     2019/6/3 23:26
 * Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        JavaSerializer serializer = new JavaSerializer();

        User user = new User();
        user.setAge(18);
        user.setName("qihao");
        user.setSex("男");

        byte[] data = serializer.serializer(user);

        System.out.println("data.length : " + data.length);

        User user1 = serializer.deserializer(data, User.class);

        System.out.println(user1);
    }
}
