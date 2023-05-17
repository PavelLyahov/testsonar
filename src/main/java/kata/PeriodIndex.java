package kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeriodIndex {
    public static final String START_INDEX = "START_INDEX";
    public static final String END_INDEX = "END_INDEX";
    private static final Map<String, Integer> indexes = new HashMap<>();

    private PeriodIndex() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Integer> getIndexes(String periodIndexAsString) {
        List<String> sequenceNumbers = Arrays.asList(periodIndexAsString.split("-"));
        int startIndex = Integer.parseInt(sequenceNumbers.stream().findFirst()
                .orElseThrow()) -1;
        int endIndex = Integer.parseInt(sequenceNumbers.get(sequenceNumbers.size() - 1)) -1;
        indexes.put(START_INDEX, startIndex);
        indexes.put(END_INDEX, endIndex);
        return indexes;
    }

}
