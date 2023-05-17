package java17Features.switchCheck;


public class SwitchCheck {

    public static void main(String[] args) {
        System.out.println(String.format("Cat has %s legs", giveMeLegCount(Pet.CAT)));
        System.out.println(String.format("DOG has %s legs", giveMeLegCount(Pet.DOG)));
        System.out.println(String.format("Fish has %s legs", giveMeLegCount(Pet.FISH)));
    }

    public static int giveMeLegCount(Pet pet) {
        return switch (pet) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> {
                System.out.println("Thi is fish, it has no legs");
                yield 0;
            }
            default -> throw new AssertionError(); // it can be removed, compiller inserts it
        };
    }

    public enum Pet {
        CAT,
        DOG,
        BIRD,
        FISH;
    }
}
