package kata.rot13;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertRot("aAzZ1 ."));
    }

    public static String convertRot(String str) {
        int rot = 13;
        int A = 65;
        int Z = 90;
        int a = 97;
        int z = 122;

        return str.chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    int num = (int) c;
                    if ((A <= num && num < A + rot) || (a <= num && num < a + rot)) {
                        num += rot;
                    } else if ((A + rot <= num && num <= Z) || (a + rot <= num && num <= z)) {
                        num -= rot;
                    }
                    return (char) num;
                })
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }

    public static String rot13(String message) {
        return message.chars().mapToObj(c -> "" + (char) c)
                .map(c -> "" + (char) (c.charAt(0) + (c.matches("(?i)[A-M]") ? 13 : c.matches("(?i)[N-Z]") ? -13 : 0)))
                .collect(Collectors.joining());
    }

}
