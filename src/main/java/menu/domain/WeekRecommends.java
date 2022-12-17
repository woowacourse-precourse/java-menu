package menu.domain;

import menu.domain.enums.Weekday;

import java.util.List;

public class WeekRecommends {

    private final Weekday weekday;
    private final List<Recommend> recommends;

    public WeekRecommends(Weekday weekday, List<Recommend> recommend) {
        this.weekday = weekday;
        this.recommends = recommend;
    }
}
