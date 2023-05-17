package kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TimePeriodTypeFilter {
    MONTHLY("Monthly", Arrays.asList("Mar 18", "Feb 18", "Jan 18", "Dec 17", "Nov 17", "Oct 17", "Sep 17", "Aug 17", "Jul 17", "Jun 17", "May 17", "Apr 17", "Mar 17", "Feb 17", "Jan 17", "Dec 16", "Nov 16", "Oct 16", "Sep 16", "Aug 16", "Jul 16", "Jun 16", "May 16", "Apr 16")),
    QUARTER("Quarter", Arrays.asList("Q1 18", "Q4 17 ", "Q3 17", "Q2 17", "Q1 17", "Q4 17", "Q3 16", "Q2 16")),
    MOVING_ANNUAL_TOTAL("Moving Annual Total", Arrays.asList("MAT 2017-2018", "MAT 2016-2017")),
    YEAR_TO_DATE("Year To Date", Arrays.asList("YTD 2018", "YTD 2017", "YTD 2016"));

    private final String name;
    private final List<String> timePeriodIndexShiftValues;

    TimePeriodTypeFilter(String name, List<String> defaultTimePeriodIndexShiftValues) {
        this.name = name;
        this.timePeriodIndexShiftValues = defaultTimePeriodIndexShiftValues;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIndexShiftValues() {
        return this.timePeriodIndexShiftValues;
    }

    public List<String> getIndexShiftValuesStream(String periodIndexAsString, String selectedOption) {
        int shift = getIndexShiftValues().indexOf(selectedOption);
        int beginningIndex = PeriodIndex.getIndexes(periodIndexAsString).get(PeriodIndex.START_INDEX) + shift;
        int endIndex = PeriodIndex.getIndexes(periodIndexAsString).get(PeriodIndex.END_INDEX) + shift;

        return getIndexShiftValues().stream().limit(beginningIndex + 1).skip(endIndex).collect(Collectors.toList());
    }

    public List<String> getIndexShiftValuesArray(String periodIndexAsString, String selectedOption) {

        int shift = getIndexShiftValues().indexOf(selectedOption);
        int beginningIndex = PeriodIndex.getIndexes(periodIndexAsString).get(PeriodIndex.START_INDEX) + shift;
        int endIndex = PeriodIndex.getIndexes(periodIndexAsString).get(PeriodIndex.END_INDEX) + shift;

        return Arrays.asList(Arrays.copyOfRange(getIndexShiftValues().toArray(new String[0]), endIndex, beginningIndex + 1));
    }

    public static List<String> getOptionsList() {
        return Stream.of(TimePeriodTypeFilter.values()).map(TimePeriodTypeFilter::getName).collect(Collectors.toList());
    }
}
