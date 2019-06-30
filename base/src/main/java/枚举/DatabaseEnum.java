package 枚举;

public enum DatabaseEnum {


    ORACLE("abc",11),MYSQL("aaa",22),SQLSERVER("bbb",33);

    // 成员变量
    private final String name;
    private final int index;


    // 构造方法
    private DatabaseEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public final String getName() {
        return name;
    }

    public final int getIndex() {
        return index;
    }

}
