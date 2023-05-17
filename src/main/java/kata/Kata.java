package kata;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata {
    public static int squareSum(int[] n) {
        int sum = 0;
        for(int i = 0; i < n.length; i++) {
            sum += Math.pow(n[i], 2);
        }
        return sum;
    }

    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }

    public static int Past(int h, int m, int s)
    {
        return s*100 + m*60*100 +h*60*60*100;
    }

    public static int sum(int[] numbers)
    {
        if(numbers == null || numbers.length <= 1 ) {
            return 0;
        }
        Integer min = IntStream.of(numbers).min().getAsInt();
        Integer max = IntStream.of(numbers).max().getAsInt();

        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        list.remove(list.indexOf(min));
        list.remove(list.indexOf(max));

        return list.stream().mapToInt(i -> i).sum();
    }

    public static int sum2(int[] numbers) {
        return (numbers == null || numbers.length <= 2) ? 0 :
                IntStream.of(numbers).sum()
                        -  IntStream.of(numbers).max().getAsInt()
                        -  IntStream.of(numbers).min().getAsInt();
    }

    public static int[] countPositivesSumNegatives(int[] input)
    {
        if(input == null || input.length <= 2) {
            return new int[]{};
        }
        int positiveCount = IntStream.of(input).filter(n -> n > 0).boxed().toList().size();
        int negativeSum = IntStream.of(input).filter(n -> n < 0).sum();
        return new int[] {positiveCount, negativeSum};
    }

    public static int[] countPositivesSumNegatives2(int[] input)
    {
        return input == null || input.length == 0 ? new int[0] :
                new int[] { (int) Arrays.stream(input).filter(i -> i > 0).count(),
                        (int) Arrays.stream(input).filter(i -> i < 0).sum()
                };
    }

    public static String MakeUpperCase(String str){
        return str.toUpperCase();
    }

    public static boolean contain2(Object[] a, Object x) {
        return Arrays.stream(a).filter(obj -> obj.equals(x)).count() > 0;
    }

    public static boolean contain22(Object[] a, Object x) {
        return Arrays.asList(a).contains(x);
    }

    public static int[] invert(int[] array) {
        int[]invert = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            invert[i] = - array[i];
        }
        return invert;
    }

    public static int[] invert2(int[] array) {
        return Arrays.stream(array).map(i -> -i).toArray();
    }

    public static String oddOrEven (int[] array) {
        return Arrays.stream(array).count() % 2 > 0 ? "even" : "odd";
    }

    public static boolean  isIsogram(String str) {
//        return str.length() == str.toLowerCase().chars().boxed().collect(Collectors.toSet()).size();
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
//        return (int)Arrays.stream(arrayOfSheeps).filter(Objects::nonNull).filter(Boolean::booleanValue).count();
        return arrayOfSheeps == null ? 0 : (int)Stream.of(arrayOfSheeps).filter(value -> value != null && value).count();
    }



    private static List<String> timePeriodIndexShiftValues =  Arrays.asList("Mar 18", "Feb 18", "Jan 18", "Dec 17", "Nov 17", "Oct 17", "Sep 17", "Aug 17", "Jul 17", "Jun 17", "May 17", "Apr 17", "Mar 17", "Feb 17", "Jan 17", "Dec 16", "Nov 16", "Oct 16", "Sep 16", "Aug 16", "Jul 16", "Jun 16", "May 16", "Apr 16");
    public static List<String> getIndexShiftValues(int maxAvailableCount) {
        List<String> indexShiftValues = timePeriodIndexShiftValues.stream().limit(maxAvailableCount).collect(Collectors.toList());
        return indexShiftValues;
    }



}