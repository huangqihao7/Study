package 单例模式.枚举单例;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 16:27
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
        EnumSingleton enumSingleton2 = EnumSingleton.getInstance();


        System.out.println(enumSingleton1 == enumSingleton2);
    }

}
