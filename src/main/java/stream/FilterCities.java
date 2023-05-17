package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCities {
    public static void main(String[] args) {
        List cities = Stream.of("Minsk", "Moscow", "Madrid", "Milan", "Rio", "Gomel").collect(Collectors.toList());
        String regex = "^[Mm].+";
        getListStartedFrom(cities, regex, 2, 3).forEach(System.out::println);
    }

    public static List<String> getListStartedFrom(List<String> list, String regex, int cityLength, int limit) {
        return list.stream()
                .filter(city -> city.matches(regex))
                .filter(city -> city.length() > cityLength)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
