package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendResult {
    private final DayWeek dayWeek;
    private final String menuName;

    public RecommendResult(DayWeek dayWeek, String menuName) {
        this.dayWeek = dayWeek;
        this.menuName = menuName;
    }

    public static String getRecommendMenuNames(List<RecommendResult> results) {
        List<String> menuNames = results.stream().map(result -> result.menuName).collect(Collectors.toList());
        return String.join(" | ", menuNames);
    }

}
