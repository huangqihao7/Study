package 原型模式;

/**
 * FileName: Test1
 * Author:   qihao
 * Date:     2019/5/27 22:22
 * Version: 1.0
 */
public class Test1 implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 t1 = new Test1("张三",18);
        Test1 t2 = (Test1) t1.clone();
        t2.setName("李四");
        t1.test();
        t2.test();
    }

    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test(){
        System.out.println(name + age + "岁");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
