package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Week {
    private final String week;
    private static final String weeks = "월화수목금";
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
        return "[ 구분 | "
                + getWeeks().stream().map(week -> week.getFormat())
                .collect(Collectors.joining(" | "))
                + " ]";
    }

    public String getFormat() {
        return week + "요일";
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }
}
