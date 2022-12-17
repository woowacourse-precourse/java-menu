package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Week {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Week> getWeeks() {
        return Arrays.asList(Week.values());
    }
}
