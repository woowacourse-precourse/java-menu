package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getDayNames() {
        return Arrays.stream(values())
                .map(day -> day.getName())
                .collect(Collectors.toList());
    }
}
