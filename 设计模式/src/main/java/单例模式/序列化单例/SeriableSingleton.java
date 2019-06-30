package 单例模式.序列化单例;

import java.io.Serializable;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 16:43
 */
public class SeriableSingleton implements Serializable {

    public final static  SeriableSingleton SERIABLE_SINGLETON = new SeriableSingleton();

    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return  SERIABLE_SINGLETON;
    }

    public Object readResolve(){
        return SERIABLE_SINGLETON;
    }

}
