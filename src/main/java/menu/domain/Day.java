package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    STANDARD("구분"),
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public static List<String> getDays() {
        return Arrays.stream(Day.values())
                .map(day -> day.name)
                .collect(Collectors.toList());
    }
}
