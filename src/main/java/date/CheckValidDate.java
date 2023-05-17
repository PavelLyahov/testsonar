package date;

import org.apache.commons.validator.GenericValidator;
import java.util.stream.Stream;

public class CheckValidDate {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    public static void main(String[] args) {
        Stream.of("2022-08-24", "2022-08-124", "2022-08-4").map(date ->isDateValid(date)).forEach(System.out::println);
    }

    public static boolean isDateValid(String date) {
        return GenericValidator.isDate(date, DATE_PATTERN, true);
    }
}
