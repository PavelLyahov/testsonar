package init;

public class TestDeveloper extends Human{
    int experience;
    static int handsCount = 3;

    {
        System.out.println("Child bloc");
    }

    static {
        System.out.println("Child static");
    }


    public TestDeveloper(int age, int experience) {

        super(age);
        System.out.println("Child constr");
        this.experience = experience;
    }
}
