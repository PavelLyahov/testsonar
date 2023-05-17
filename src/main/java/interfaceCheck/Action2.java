package interfaceCheck;

public interface Action2 {
    default void move(){
        System.out.println("I action 2 move ");
    }
}
