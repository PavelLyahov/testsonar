package interfaceCheck;

public interface Action {
    default void move(){
        System.out.println("I am action move");
    }

    private void moveHelper() {
        System.out.println("I help to move");
    }
}
