package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DayOfTheWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");
    
    private final String name;
    
    DayOfTheWeek(String name) {
        this.name = name;
    }
    
    private String getName() {
        return name;
    }
    
    public static List<String> getNames() {
        return Arrays.stream(values())
                .map(DayOfTheWeek::getName)
                .collect(Collectors.toList());
    }
}
