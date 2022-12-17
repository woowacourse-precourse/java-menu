package menu.domain;

import java.util.List;

public enum Day {

    MONDAY("월요일", 0),
    TUESDAY("화요일", 1),
    WEDNESDAY("수요일", 2),
    THURSDAY("목요일", 3),
    FRIDAY("금요일", 4);

    private final String name;
    private final int index;

    Day(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
}
