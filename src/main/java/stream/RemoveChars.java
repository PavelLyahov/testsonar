package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveChars {
    public static void main(String[] args) {
        String str = "agh 234f4 34g22h";
        System.out.println(getNumbersFromString(str));
        getListOfConsonants(str).forEach(System.out::println);
        Arrays.stream(str.split("[^0-9]")).forEach(System.out::println);
    }

    public static String getNumbersFromString(String str) {
        return Arrays.stream(str.split(""))
                .filter(character -> character.matches("[0-9]+"))
                .map(Integer::parseInt)
                .map(String::valueOf).collect(Collectors.joining());
    }

    public static List<String> getListOfConsonants(String str) {
        return Arrays.stream(str.split("[0-9]+"))
                .collect(Collectors.toList());
    }

}
