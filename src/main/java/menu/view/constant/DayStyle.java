package menu.view.constant;

import menu.constant.Day;

import java.util.Arrays;

public enum DayStyle {
    MONDAY(Day.MONDAY, "월요일"),
    TUESDAY(Day.TUESDAY, "화요일"),
    WEDNESDAY(Day.WEDNESDAY, "수요일"),
    THURSDAY(Day.THURSDAY, "목요일"),
    FRIDAY(Day.FRIDAY, "금요일");

    private final Day day;
    private final String style;

    DayStyle(Day day, String style) {
        this.day = day;
        this.style = style;
    }

    public static String findStyleByDay(Day day) {
        return Arrays.stream(DayStyle.values())
                .filter(elem -> day == elem.day)
                .findAny()
                .orElseThrow()
                .getStyle();
    }

    public Day getDay() {
        return day;
    }

    public String getStyle() {
        return style;
    }
}
