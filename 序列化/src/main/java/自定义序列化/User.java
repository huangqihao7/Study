package 自定义序列化;

import java.io.Serializable;

/**
 * FileName: User
 * Author:   qihao
 * Date:     2019/6/3 22:27
 * Version: 1.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5323419166697942164L;

    private transient String name;
    private transient String sex;
    private int age;

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        s.defaultWriteObject();

        s.writeObject(name);
        s.writeObject(sex);
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();

        name = (String) s.readObject();
        sex = (String) s.readObject();
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
