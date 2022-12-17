package menu.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Weekday {

    MONDAY(1, "월요일"),
    TUESDAY(2, "화요일"),
    WEDNESDAY(3, "수요일"),
    THURSDAY(4, "목요일"),
    FRIDAY(5, "금요일");

    private static final String CLASS_NAME = "구분";

    private int weekNumber;
    private String name;

    Weekday(int weekNumber, String name) {
        this.weekNumber = weekNumber;
        this.name = name;
    }

    public static String getClassName() {
        return CLASS_NAME;
    }

    public static List<Weekday> getOrderedWeekdays() {
        return Arrays.stream(Weekday.values())
                .sorted(Comparator.comparing(weekday -> weekday.weekNumber))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
