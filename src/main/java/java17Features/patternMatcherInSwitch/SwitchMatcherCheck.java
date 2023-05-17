package java17Features.patternMatcherInSwitch;

import java.util.Collection;
import java.util.List;

public class SwitchMatcherCheck {

    public static void main(String[] args) {
        print(Pets.CAT);
        print(List.of("Cat", "Dog"));
        int[] arr = {33,3,4,5};
        print(arr);
        String nullStr = null;
        print(nullStr);
    }

    static private void print(Object obj) {
        System.out.println(asString(obj));
    }

    static String asString(Object obj) {
        return switch (obj) {
            //case Enum<?> e -> e.getDeclaringClass().getSimpleName() + "." + e.name();
           // case Collection c -> "Collection Size: %d".formatted(c.size());
            //case Object[] arr -> "Integer array size: %d".formatted(arr.length);
            //case int[] arr -> "Integer array size: %d".formatted(arr.length);
//            case String s->
//                    switch (s.length()) {
//                        case 10 -> '"' + s.substring(0, 10) + "...\"";
//                        case 20 -> '"' + s.substring(0, 20) + "...\"";
//                        default -> throw new IllegalStateException("Unexpected value: " + s.length());
//                    };
//            case null -> "Null";
            default -> obj.toString();
        }; //check cases by order
    }
}

enum Pets {
    DOG,
    CAT,
    FISH;
}


