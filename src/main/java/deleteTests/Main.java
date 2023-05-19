package deleteTests;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long microsenconds = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        StringBuilder sellerIdTimestamp = new StringBuilder(String.valueOf(microsenconds));
        //sellerIdTimestamp.insert(13, '-');
        System.out.println(sellerIdTimestamp);

    }
}
//1678736390685-000
//1678736366148-000
