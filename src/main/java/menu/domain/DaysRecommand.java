package menu.domain;

import menu.util.DayStatus;

import java.util.ArrayList;
import java.util.List;

public class DaysRecommand {
    private List<Day> days;

    DaysRecommand(List<Day> days) {
        this.days = days;
    }

    public static DaysRecommand of() {
        return new DaysRecommand(initDays());
    }

    public static List<Day> initDays() {
        List<Day> days = new ArrayList<>();
        for (DayStatus dayStatus : DayStatus.values()) {
            days.add(Day.of(dayStatus.getDay()));
        }
        return days;
    }

    public List<Day> getDays() {
        return days;
    }
}
