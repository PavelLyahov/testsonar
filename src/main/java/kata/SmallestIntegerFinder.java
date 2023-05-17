package kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        Arrays.sort(args);
        return args[0];
    }

    public static int findSmallestInt2(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }
}
