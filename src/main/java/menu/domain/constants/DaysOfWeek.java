package menu.domain.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DaysOfWeek {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");
    public static final int COUNT = 5;
    private static final String START = "구분";
    private final String name;

    DaysOfWeek(String name) {
        this.name = name;
    }

    public static List<String> getDaysOfWeek() {
        List<String> daysOfWeek = new ArrayList<>();
        daysOfWeek.add(START);
        Arrays.stream(values())
                .forEach(day -> daysOfWeek.add(day.name));
        return daysOfWeek;
    }
}
