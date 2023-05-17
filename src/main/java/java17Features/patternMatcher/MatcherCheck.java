package java17Features.patternMatcher;

public class MatcherCheck {

    public static void main(String[] args) {
        checkType("Bla bla bla");
        checkType("");
        checkType(5);
    }

    public static void checkType(Object obj) {
        if (obj instanceof String str && !str.isEmpty()) {
            System.out.println("This is not empty string: " + str);
        } else if (obj instanceof String) {
            System.out.println("This is empty string");
        } else if (obj instanceof Number number) {
            System.out.println("This is number: " + number);
        } else {
            System.out.println("This is something else");
        }
    }
}
