package jae;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class ValidTime {
    /**
    * Дан лист с набором строк в формате чч:мм, нужно вывести в консоль количество корректных элементов
    **/
    public static void main(String[] args) {
        List<String> temp = Arrays.asList("09:00", "08:00", "25:95", "13:80");
        System.out.println(correctTimeList(temp).size());
    }

    private static List<String> correctTimeList(List<String> time) {
        return time.stream().filter(ValidTime::checkIsTimeCorrect).toList();
    }

//    private static boolean checkIsTimeCorrect(String time) {
//        String[] split = time.split(":");
//        int hour = Integer.parseInt(split[0]);
//        int min = Integer.parseInt(split[1]);
//        return ((hour >= 0 && hour < 24) && (min >= 0 && min < 60));
//    }


    private static boolean checkIsTimeCorrect(String time){
        try {
            LocalTime.parse(time);
            return true;
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
    }

    public double getValue(String value) {
        return value != null ? Double.parseDouble(value) : 0;
    }
}
