package enumCheck;

public enum Users implements Action{
    ANTON("Toha"),
    PAVEL("Pasha"),
    IVAN("Vania");

    private String name;

    Users(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("%s moves".formatted(this.name));
    }

    @Override
    public void eat() {

    }
}
