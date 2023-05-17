package stringTrainingTasks;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final byte T = 45;
    private static final byte _code = 95;

    public static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    //the_Stealth_Warrior
    public static String toCamelCase(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '_' || str.charAt(i) == '-') {
                i++;
                output += Character.toUpperCase(str.charAt(i) );
            } else {
                output += str.charAt(i);
            }
        }
        return output;
    }

    // pov(2, x - 1)
    // 1 -                                                                       - 1
    // 2 - 21                                                                    - 2
    // 3 - 32 31         321                                                     - 4
    // 4 - 43 42 41 -    432 431 421              - 4321                         - 8
    // 5 - 54 53 52 51 - 543 542 541  532 531 521 - 5432 5431 5421 5321 - 54321  -16

    public static <T> long count(T[] elems) {
        Set uniqueElements = new HashSet<T>(Arrays.asList(elems));
        int countUniqueElem = uniqueElements.size();
        System.out.println(countUniqueElem);
        long countVariants = 0;
        while (countUniqueElem > 0) {
            countVariants += (long) Math.pow(2, (countUniqueElem - 1));
            System.out.println(countVariants);
            countUniqueElem--;
        }
        return countVariants;
    }

    static <T> long countBetter(T[] elems) {
        return (long) Math.pow(2, Arrays.stream(elems).distinct().toArray().length) -1;
    }



}
