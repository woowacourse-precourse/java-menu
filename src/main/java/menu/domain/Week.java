package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.view.OutputView;

public class Week {
    private final String week;
    private static final String weeks = "월화수목금";
    private static final String DAY = "요일";
    private Category category = null;

    public Week(String week) {
        this.week = week;
    }

    public static List<Week> getWeeks() {
        return Arrays.stream(weeks.split(""))
                .map(Week::new)
                .collect(Collectors.toList());
    }

    public static String getWeekFormat() {
        return OutputView.WEEK_LINE_START
                + getWeeks().stream().map(week -> week.getFormat())
                .collect(Collectors.joining(OutputView.RESULT_SEPERATOR))
                + OutputView.LINE_END;
    }

    public String getFormat() {
        return week + DAY;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }
}
