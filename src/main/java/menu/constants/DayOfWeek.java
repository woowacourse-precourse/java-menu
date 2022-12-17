package menu.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DayOfWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private static final List<String> dayOfWeek = Stream.of(values())
            .map(DayOfWeek::getWeekOfDay)
            .collect(Collectors.toList());
    private final String weekOfDay;

    DayOfWeek(String weekOfDay) {
        this.weekOfDay = weekOfDay;
    }

    private String getWeekOfDay() {
        return weekOfDay;
    }

    public static List<String> getWeekOfDayList() {
        return dayOfWeek;
    }
}
