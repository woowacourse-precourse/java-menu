package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Weekly {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String name;

    Weekly(String name) {
        this.name = name;
    }

    public static List<String> getAllDays() {
        return Arrays.stream(values()).map(Weekly::getName).collect(Collectors.toList());
    }

    public static int getAllDaySize() {
        return values().length;
    }

    public String getName() {
        return name;
    }
}
