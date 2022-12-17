package menu.model.enums;

import java.util.Arrays;

public enum Days {
    Monday("월요일"),
    Tuesday("화요일"),
    Wednesday("수요일"),
    Thursday("목요일"),
    Friday("금요일");

    private final String name;

    Days(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
