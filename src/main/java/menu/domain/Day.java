package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    STANDARD("구분", 0),
    MON("월요일", 1),
    TUE("화요일", 2),
    WED("수요일", 3),
    THU("목요일", 4),
    FRI("금요일", 5);

    private final String name;
    private final int index;

    Day(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static List<String> getDays() {
        List<String> daysForm = new ArrayList<>();
        daysForm.addAll(Arrays.stream(Day.values())
                .map(day -> day.name)
                .collect(Collectors.toList()));
        return daysForm;
    }

    public int getIndex() {
        return index;
    }
}
