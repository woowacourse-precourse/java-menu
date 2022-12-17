package menu.repository;

import menu.domain.Day;
import menu.domain.WeeklyMenu;

import java.util.HashMap;
import java.util.Map;

public class WeeklyMenuRepository {
    private static Map<Day, WeeklyMenu> weeklyMenus = new HashMap<>();
}
