package 工厂模式.工厂方法模式;

public class PythonCourse implements Icourse {

    @Override
    public void note() {
        System.out.println("python课程笔记");
    }

    @Override
    public void record() {
        System.out.println("录制python课堂视频");
    }
}
