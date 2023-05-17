package kata;

public class VarAsCopy {
    static int a;

    public static void main(String[] args) {
        System.out.println(a);
        pusOne(a);
        System.out.println(a);
    }

    public static void pusOne(int number) {
        ++number;
    }
}
