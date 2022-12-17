package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;

public class HardToEatRepository {

    private static final Map<Coach, List<String>> menus = new HashMap<>();

    public static void addMenus(Coach coach, String menu) {
        processExistCoach(coach, menu);
        processNotExistCoach(coach, menu);
    }

    private static void processExistCoach(Coach coach, String menu) {
        if (menus.containsKey(coach)) {
            List<String> menuNames = menus.get(coach);
            storeMenu(menu, menuNames);
        }
    }

    private static void storeMenu(String menu, List<String> menuNames) {
        if (!menuNames.contains(menu)) {
            menuNames.add(menu);
        }
    }

    private static void processNotExistCoach(Coach coach, String menu) {
        if (!menus.containsKey(coach)) {
            menus.put(coach, new ArrayList<>(List.of(menu)));
        }
    }

    public static List<String> findByCoach(Coach coach) {
        if (menus.containsKey(coach)) {
            return menus.get(coach);
        }
        return new ArrayList<>();
    }
}
