package menu.repository;

import menu.domain.Category;
import menu.domain.CoachMenu;
import menu.domain.Day;
import menu.domain.WeeklyMenu;

import java.util.HashMap;
import java.util.Map;

public class WeeklyMenuRepository {
    private static Map<Day, WeeklyMenu> weeklyMenus = new HashMap<>();

    public void saveWeeklyMenu(Day day, WeeklyMenu weeklyMenu) {
        weeklyMenus.put(day, weeklyMenu);
    }

    public boolean isValidCategory(Category category) {
        long categoryCount = weeklyMenus.keySet().stream()
                .filter(key -> weeklyMenus.get(key).isSameCategory(category))
                .count();
        return categoryCount < 2;
    }

    public boolean isDuplicatedCoachMenu(CoachMenu coachMenu) {
        return weeklyMenus.keySet().stream()
                .anyMatch(day -> weeklyMenus.get(day).isDuplicatedCoachMenu(coachMenu));
    }
}
