package kata;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int n[] = new int[] {1,2,3, -5};
        String[] points = new String[] {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"};
//        System.out.println(kata.Kata.squareSum(n));
//        System.out.println(StringToNumber.stringToNumber("123"));
//        System.out.println(kata.SmallestIntegerFinder.findSmallestInt(n));
//        System.out.println(kata.Positive.sum(n));
//        System.out.println(kata.TotalPoints.points(points));
//        System.out.println(kata.Kata.boolToWord(true));
//        System.out.println(kata.Kata.Past(0,1,1));
//        System.out.println(kata.Kata.sum(new int[] { 6, 2, 1, 8, 10, 10}));
//        System.out.println(kata.Kata.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
//        System.out.println(kata.Kata.check(new Object[] {"what", "a", "great", "kata"}, "kat"));
//        System.out.println(kata.Kata.invert(new int[] {1,2,3,4,5}));
//        System.out.println(kata.Kata.oddOrEven(new int[] {2, 5, 34}));
//        System.out.println(kata.Kata.isIsogram("moose"));
//        System.out.println(kata.Kata.countSheeps(new Boolean[]{null, true, false}));


        String str = "[3,429][533,1095]";
        List<String> mas = Arrays.asList(str.split("[,\\]\\[]+"));
        System.out.println(mas.size());
        mas.forEach(System.out::println);

        List<String> mmas = mas.stream().filter(el -> !el.isEmpty()).collect(Collectors.toList());
        System.out.println(mmas.size());
        mmas.forEach(System.out::println);

        System.out.println(new Dimension(1, 2).equals(new Dimension(1, 2)));
        Object object = new Object(

        );



    }
}
