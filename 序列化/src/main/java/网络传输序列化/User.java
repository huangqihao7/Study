package 网络传输序列化;

import java.io.Serializable;

/**
 * FileName: User
 * Author:   qihao
 * Date:     2019/6/3 22:27
 * Version: 1.0
 */
public class User implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
