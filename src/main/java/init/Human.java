package init;

public class Human {
    int age;
    static int handsCount = 2;

    {
        System.out.println("Parent block");
    }

    static {
        System.out.println("Parent static");
    }

    public Human(int age) {
        System.out.println("Parent constr");
        this.age = age;
    }


}
