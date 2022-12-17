package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAYS("금요일");

    private String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public static List<Day> getDayList() {
//        return Arrays.stream(Day.values())
//                .collect(Collectors.toList());
//    }
    //TODO

    public static List<String> getDayValueList() {
        return Arrays.stream(Day.values())
                .map(Day::getName)
                .collect(Collectors.toList());
    }
}
