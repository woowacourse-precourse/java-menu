package menu.domain;

import java.util.Objects;

public class RecommendResult {
    private final DayWeek dayWeek;
    private final String menuName;

    public RecommendResult(DayWeek dayWeek, String menuName) {
        this.dayWeek = dayWeek;
        this.menuName = menuName;
    }
}
