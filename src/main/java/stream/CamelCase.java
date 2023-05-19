package stream;

import java.util.Arrays;
public class CamelCase {

    public static void main(String[] args) {
        System.out.println("---" +toCamelCase("the_tea_in_Nepal_is_very_hot")  + "---");
    }

    static String toCamelCase(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
