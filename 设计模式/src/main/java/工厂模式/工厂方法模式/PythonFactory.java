package 工厂模式.工厂方法模式;

public class PythonFactory {

    public Icourse create(){

        return new PythonCourse();
    }

}
