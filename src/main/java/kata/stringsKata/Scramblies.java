package kata.stringsKata;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    public static void main(String[] args) {
        int repeate = 100;
        String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(repeate);
        String s2 = "zyxcba".repeat(repeate);

        for(int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Scramblies.scramble(s1, s2);
            long finish = System.nanoTime();
            System.out.println(i + " - " + (double) (finish - start) / 10000000);
        }
    }

    private static void testing(boolean actual, boolean expected) {
        Assert.assertEquals(expected, actual);
    }

    public static void sampleTests() {
        testing(Scramblies.scramble("rkqodlw","world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Scramblies.scramble("katas","setak"),false);
        testing(Scramblies.scramble("scriptjavx","javascript"),false);
        testing(Scramblies.scramble("scriptingjava","javascript"),true);
        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
        testing(Scramblies.scramble("javscripts","javascript"),false);
        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
        testing(Scramblies.scramble("commas","commas"),true);
        testing(Scramblies.scramble("sammoc","commas"),true);
    }

    public static boolean scramble(String str1, String str2) {
        if (str2.equals(str1) || str1.contains(str2)) {
            return true;
        } else if (str2.length() > str1.length()) {
            return false;
        } else {
            return compareUsingHashMap(str1, str2);
        }
    }

    private static boolean compareUsingHashMap(String str1, String str2) {
        var pairsStr1 = toCountMap(str1);
        for (Map.Entry<Character, Integer> pair : toCountMap(str2).entrySet()) {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            if (!pairsStr1.containsKey(key)) {
                return false;
            } else if (pairsStr1.get(key) < value) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> toCountMap(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character character: str.toCharArray()) {
            count.merge(character, 1, Integer::sum);
        }
        return count;
    }

}
