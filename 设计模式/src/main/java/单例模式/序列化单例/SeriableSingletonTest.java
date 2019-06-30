package 单例模式.序列化单例;

import java.io.*;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 16:45
 */
public class SeriableSingletonTest {

    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 =  SeriableSingleton.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("seriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("seriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton) ois.readObject();
            ois.close();
            fis.close();

            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
