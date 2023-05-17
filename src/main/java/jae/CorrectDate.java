package jae;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * количество корректных дат в dates равно 1
 */
public class CorrectDate {

    public static void main(String[] args) {
        List<String> dates = Arrays.asList("30.02", "01.01", "04.19", "90.09");
        System.out.println(correctTimeList(dates).size());
    }

    private static List<String> correctTimeList(List<String> time) {
        return time.stream().filter(CorrectDate::isDateValid).toList();
    }

    private static boolean isDateValid(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        try {
            LocalDate.parse(dateStr + ".2003", formatter);
            System.out.println(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}

