package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DayOfTheWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String name;

    DayOfTheWeek(String name) {
        this.name = name;
    }

    public static List<DayOfTheWeek> getDaysOfTheWeek() {
        return Arrays.stream(values())
                .collect(Collectors.toList());
    }
}
