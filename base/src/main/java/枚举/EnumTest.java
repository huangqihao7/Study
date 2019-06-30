package 枚举;

public class EnumTest {

    public static void main(String[] args) {

        DatabaseEnum[] values = DatabaseEnum.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].ordinal());
        }

    }
}
