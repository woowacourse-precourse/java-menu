package menu.model.menutable;

import menu.model.coach.Coach;
import menu.model.menu.Category;

import java.util.ArrayList;
import java.util.List;

public class MenuTableGenerator {
    public static WeeklyMenuTable makeWeeklyMenuTable(List<Category> categoryList, List<Coach> coachList) {
        List<DailyMenuTable> dailyMenuTableList = new ArrayList<>();
        List<CoachState> coachStateList = makeCoachStateList(coachList);

        DailyMenuTable dailyMenuTable = makeDailyMenuTable(coachStateList);
        for(Category category: categoryList) {
            dailyMenuTable.fillDailyMenuTable(category);
            dailyMenuTableList.add(dailyMenuTable);
            dailyMenuTable = dailyMenuTable.initNewDailyMenuTable();
        }

        return new WeeklyMenuTable(dailyMenuTableList);
    }

    private static List<CoachState> makeCoachStateList(List<Coach> coachList) {
        List<CoachState> coachStateList = new ArrayList<>();
        for(int i = 0; i < coachList.size(); i++) {
            coachStateList.add(new CoachState(coachList.get(i)));
        }
        return coachStateList;
    }

    private static DailyMenuTable makeDailyMenuTable(List<CoachState> coachStateList) {
        return DailyMenuTable.makeInitDailyMenuTable(coachStateList);
    }
}
