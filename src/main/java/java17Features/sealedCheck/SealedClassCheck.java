package java17Features.sealedCheck;

public class SealedClassCheck {

}

abstract sealed class Pet permits Cat, Dog {
}

sealed interface Action permits Cat, Dog {
    void sound();
}

final class Cat extends Pet implements Action {
    public void sound() {
        System.out.println("Miu");
    }
}

final class Dog extends Pet implements Action {
    public void sound() {
        System.out.println("Af");
    }
}

