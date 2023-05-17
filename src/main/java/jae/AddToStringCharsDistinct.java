package jae;

import java.util.Arrays;
import java.util.List;

/**
 * Реализовать метод, добавляющий к строке 1 если в ней есть повторяющиеся символы или 0 если их нет
 */
public class AddToStringCharsDistinct {
    public static void main(String[] args) {
        System.out.println(doubleString("aa", "ab", "bcde", "defg", "cee", "ffff"));
    }

    public static List<String> doubleString(String... values) {
        return Arrays.stream(values)
                .map(str -> (str.length() != str.chars().distinct().count()) ? str + "1" : str + "0")
                .toList();
    }
}
