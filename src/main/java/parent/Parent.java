package parent;

public class Parent {
    private static int counter = 0;
    Parent() {
        counter++;
    }

    public int getCount() {
        return counter;
    }

    protected void foo() {
        System.out.println("I am parent");
    }
}
