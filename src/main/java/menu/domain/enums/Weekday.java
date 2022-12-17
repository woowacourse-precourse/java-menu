package menu.domain.enums;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public enum Weekday {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    ;

    private final String dayName;

    Weekday(String dayName) {
        this.dayName = dayName;
    }

    public static List<Weekday> weekdays() {
        return stream(values())
                .collect(toUnmodifiableList());
    }

    public String dayName() {
        return dayName;
    }
}
