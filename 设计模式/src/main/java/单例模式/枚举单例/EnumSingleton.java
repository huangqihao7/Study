package 单例模式.枚举单例;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 16:21
 */
public enum EnumSingleton {

    SINGLETON;

    public static EnumSingleton getInstance(){
        return EnumSingleton.SINGLETON;
    }

}
