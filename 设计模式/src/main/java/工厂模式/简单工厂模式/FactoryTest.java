package 工厂模式.简单工厂模式;

public class FactoryTest {

    public static void main(String[] args) {
        ICourseFactory factory = new ICourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.course();
    }
}
