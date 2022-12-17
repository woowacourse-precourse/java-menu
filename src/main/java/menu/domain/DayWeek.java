package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DayWeek{
    MON("월요일")
    , TUE("화요일")
    , WED("수요일")
    , THU("목요일")
    , FRI("금요일");

    private final String value;

    DayWeek(String value) {
        this.value = value;
    }

    public static String getDayWeekInfo() {
        List<String> dayWeekInfos = Arrays.stream(DayWeek.values()).map(dayWeek -> dayWeek.value).collect(Collectors.toList());
        return "[ 구분 | " + String.join(" | ", dayWeekInfos) + " ]";
    }
}
