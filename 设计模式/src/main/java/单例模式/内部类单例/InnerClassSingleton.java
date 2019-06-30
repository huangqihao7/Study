package 单例模式.内部类单例;

/**
 * @Author: huangqihao
 * @Date: 2019/6/30 17:01
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){
        if (LazyHolder.LAZY != null){
            throw new RuntimeException("一时装逼一时爽，一直装逼一直爽！");
        }
    }

    public static InnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final  InnerClassSingleton LAZY = new InnerClassSingleton();
    }

}
