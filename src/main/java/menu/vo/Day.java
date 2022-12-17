package menu.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public static List<String> findAllNames() {
        return Arrays.stream(values())
                .map(Day::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
