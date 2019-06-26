package 工厂模式.工厂方法模式;

public class FactoryTest {

    public static void main(String[] args) {
        JavaFactory factory = new JavaFactory();
        Icourse icourse = factory.create();
        icourse.note();
        icourse.record();

    }

}
