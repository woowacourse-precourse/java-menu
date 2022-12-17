package menu.domain;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Day {
    MONDAY("월요일", 0),
    TUESDAY("화요알", 1),
    WEDNESDAY("수요일", 2),
    THURSDAY("목요일", 3),
    FRIDAY("금요일", 4);

    private String day;
    private int number;

    Day(String day, int number) {
        this.day = day;
        this.number = number;
    }

    private static final Map<String, Day> BY_DAY =
            Stream.of(values()).collect(Collectors.toMap(Day::getDay, Function.identity()));

    public static Day valueOfDay(String day) {
        return BY_DAY.get(day);
    }

    public String getDay() {
        return day;
    }

    public int getNumber() {
        return number;
    }
}

