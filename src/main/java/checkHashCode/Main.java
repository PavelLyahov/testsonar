package checkHashCode;

import java.util.AbstractSet;

public class Main {
    public static void main(String[] args) {
        A a = new A("Alan");
        A a2 = new A("Alan");
        System.out.println(System.identityHashCode(a));
        a.name = "NotAlan";
        System.out.println("a " + a.hashCode());
        System.out.println("a2 " + a2.hashCode());
        System.out.println(a.equals(a2));

        System.out.println(a.hashCode());
        A copyA = a;
        System.out.println(copyA.hashCode());
        System.out.println(copyA == a);
        copyA.name = "Ben";
        System.out.println(copyA.hashCode());
        System.out.println(a.equals(a2));

    }
}
