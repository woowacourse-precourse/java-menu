package menu.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Day {
    MONDAY(0, "월요일"),
    TUESDAY(1, "화요일"),
    WEDNESDAY(2, "수요일"),
    THURSDAY(3, "목요일"),
    FRIDAY(4, "금요일");

    private final int code;
    private final String name;

    Day(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Day getMatchDay(Predicate<Day> predicate) {
        return Arrays.stream(values()).filter(predicate).findAny().get();
    }
}
