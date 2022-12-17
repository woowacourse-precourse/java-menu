package menu.dto;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.RecommendMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendResultDTO {

    private List<String> categories = new ArrayList<>();
    private Map<String, List<String>> menus = new HashMap<>();

    public RecommendResultDTO(Coaches coaches) {
        List<String> coachNames = coaches.getCoachNames();
        for (String coachName : coachNames) {
            List<String> menuList = new ArrayList<>();
            menus.put(coachName, menuList);
        }
    }

    public void addCategory(String categoryName) {
        categories.add(categoryName);
    }

    public void addMenus(Coaches coaches, RecommendMenu recommendMenu) {
        List<String> allCoachesNames = coaches.getAllCoachesNames();
        for (String coachesName : allCoachesNames) {
            Coach coach = coaches.findByName(coachesName);
            List<String> menuList = recommendMenu.getMenus(coach);
            menus.get(coachesName).addAll(menuList);
        }
    }
}
