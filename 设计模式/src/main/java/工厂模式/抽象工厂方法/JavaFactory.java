package 工厂模式.抽象工厂方法;

public class JavaFactory implements IcourseFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IRecord createRecord() {
        return new JavaRecord();
    }
}
