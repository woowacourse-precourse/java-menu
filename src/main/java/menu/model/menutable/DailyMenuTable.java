package menu.model.menutable;

import menu.model.menu.Category;
import menu.model.menu.Menu;
import menu.model.menu.RandomMenuGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyMenuTable {
    private Map<CoachState, Menu> dailyMenuTable;

    private DailyMenuTable(Map<CoachState, Menu> dailyMenuTable) {
        this.dailyMenuTable = new HashMap<>();
    }

    public static DailyMenuTable makeInitDailyMenuTable(List<CoachState> coachStateList) {
        return new DailyMenuTable(initMap(coachStateList));
    }

    private static Map<CoachState, Menu> initMap(List<CoachState> coachStateList) {
        Map<CoachState, Menu> newMap = new HashMap<>();
        for(CoachState coachState : coachStateList) {
            newMap.put(coachState, null);
        }
        return newMap;
    }

    public void fillDailyMenuTable(Category category) {
        RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

        for(CoachState coachState : dailyMenuTable.keySet()) {
            dailyMenuTable.put(coachState, randomMenuGenerator.pickMenuByCategory(category, coachState.getExceptedMenu()));
        }
    }

    public DailyMenuTable initNewDailyMenuTable() {
        DailyMenuTable newTable = new DailyMenuTable(initMap(getNewCoachStateList()));
        return newTable;
    }

    List<CoachState> getNewCoachStateList() {
        List<CoachState> coachStateList = new ArrayList<>(dailyMenuTable.keySet());
        for(CoachState coachState : coachStateList) {
            coachState.addExceptedMenu(dailyMenuTable.get(coachState));
        }
        return coachStateList;
    }
}
