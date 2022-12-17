package menu.util;

import java.util.ArrayList;
import java.util.List;

public enum DayStatus {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    private final String day;

    DayStatus(String day) {
        this.day = day;
    }

    public static List<String> getDays() {
        List<String> days = new ArrayList<>();
        for (DayStatus dayStatus : DayStatus.values()) {
            days.add(dayStatus.day);
        }
        return days;
    }

    public String getDay() {
        return day;
    }
}
