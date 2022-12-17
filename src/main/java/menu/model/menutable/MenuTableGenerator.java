package menu.model.menutable;

import menu.model.coach.Coach;

import java.util.ArrayList;
import java.util.List;

public class MenuTableGenerator {
    public static DailyMenuTable makeDailyMenuTable(List<Coach> coachList) {
        // TODO 구현 필요

        return new DailyMenuTable(new ArrayList<>());
    }

    public static WeeklyMenuTable makeWeeklyMenuTable(List<Coach> coachList) {
        // TODO 구현 필요

        return new WeeklyMenuTable(new ArrayList<>());
    }
}
