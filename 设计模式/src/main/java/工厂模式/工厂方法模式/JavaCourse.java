package 工厂模式.工厂方法模式;

public class JavaCourse implements Icourse {

    @Override
    public void note() {
        System.out.println("java课程笔记");
    }

    @Override
    public void record() {
        System.out.println("录制java课程视频");
    }
}
