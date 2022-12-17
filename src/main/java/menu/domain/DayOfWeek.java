package menu.domain;

import java.util.Arrays;

public enum DayOfWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private static final String INVALID_DAY_OF_WEEK_VALUE_MESSAGE = "유효하지 않은 값입니다.";
    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    //TODO: val의 네이밍 꼭 변경하기
    public DayOfWeek from(String name) {
        return Arrays.stream(values())
                .filter(day -> day.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_DAY_OF_WEEK_VALUE_MESSAGE));
    }
}
