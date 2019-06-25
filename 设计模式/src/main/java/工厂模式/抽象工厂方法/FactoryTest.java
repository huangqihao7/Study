package 工厂模式.抽象工厂方法;

public class FactoryTest {

    public static void main(String[] args) {
        JavaFactory factory = new JavaFactory();
        factory.createNote().note();
        factory.createRecord().record();
    }

}
