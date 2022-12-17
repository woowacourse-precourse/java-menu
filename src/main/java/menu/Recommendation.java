package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommendation {
    private final Map<String, List<String>> coachInedible;
    private final Map<String, List<String>> coachMenu = new HashMap<>();
    private final Category category;
    private final Menu menu;

    public Recommendation(Map<String, List<String>> coachInedible) {
        this.coachInedible = coachInedible;
        this.category = new Category();
        this.menu = new Menu();
    }

    public boolean addMenu(String coach, String menu) {
        if (checkEdible(coach, menu) && checkNotDuplication(coach, menu)) {
            List<String> currentMenu = coachMenu.get(coach);
            currentMenu.add(menu);
            coachMenu.replace(coach, currentMenu);
            return true;
        }
        return false;
    }

    public boolean checkNotDuplication(String coach, String menu) {
        if (coachMenu.get(coach).contains(menu)) {
            return false;
        }
        return true;
    }

    public boolean checkEdible(String coach, String menu) {
        if (coachInedible.get(coach).contains(menu)) {
            return false;
        }
        return true;
    }

    public Map<String, List<String>> get() {
        return this.coachMenu;
    }
}
