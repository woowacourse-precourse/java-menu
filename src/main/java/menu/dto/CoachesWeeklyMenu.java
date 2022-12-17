package menu.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Menu;

public class CoachesWeeklyMenu {

    private List<String> categoriesNames = new ArrayList<>();
    private Map<String, List<String>> eachCoachesMenu = new HashMap<>();

    public List<String> getCategoriesNames() {
        return categoriesNames;
    }

    public Map<String, List<String>> getEachCoachesMenu() {
        return eachCoachesMenu;
    }

    public CoachesWeeklyMenu(List<String> categoriesNames) {
        this.categoriesNames = categoriesNames;
    }
}
