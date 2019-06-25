package 工厂模式.简单工厂模式;

public class ICourseFactory {

    public ICourse create(Class clazz) {
        try {
            return  (ICourse)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
