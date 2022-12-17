package menu.dto.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;

public class CoachesWeeklyMenu {

    private final List<String> categoriesNames;
    private final Map<String, List<String>> eachCoachesMenu;

    public static CoachesWeeklyMenu from(List<Category> categories,
                                         Coaches coaches) {
        List<String> categoriesNames = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        Map<String, List<String>> eachCoachesMenu = getEachCoachesMenu(coaches);
        return new CoachesWeeklyMenu(categoriesNames, eachCoachesMenu);
    }

    private static Map<String, List<String>> getEachCoachesMenu(Coaches coaches) {
        Map<String, List<String>> eachCoachesMenu = new HashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            String name = coach.getName();
            List<String> menuNames = coach.getLunchMenus()
                    .stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList());
            eachCoachesMenu.put(name, menuNames);
        }
        return eachCoachesMenu;
    }

    private CoachesWeeklyMenu(List<String> categoriesNames,
                             Map<String, List<String>> eachCoachesMenu) {
        this.categoriesNames = categoriesNames;
        this.eachCoachesMenu = eachCoachesMenu;
    }

    public List<String> getCategoriesNames() {
        return categoriesNames;
    }

    public Map<String, List<String>> getEachCoachesMenu() {
        return eachCoachesMenu;
    }

}
