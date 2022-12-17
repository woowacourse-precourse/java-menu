package menu.domain.initialdata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    MON("월요일"),
    TUE("화요일"),
    WEN("수요일"),
    THU("목요일"),
    FRI("금요일");
    private final String day;

    private static List<String> days = Arrays.stream(values())
            .map(Day::getDay)
            .collect(Collectors.toList());

    Day(String day) {
        this.day = day;
    }

    public static List<String> getDays() {
        return days;
    }

    private String getDay() {
        return day;
    }
}
