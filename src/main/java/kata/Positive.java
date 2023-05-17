package kata;

import java.util.stream.IntStream;

public class Positive {
    public static int sum(int[] arr){
        return IntStream.of(arr).filter(number -> number > 0).sum();
    }
}
