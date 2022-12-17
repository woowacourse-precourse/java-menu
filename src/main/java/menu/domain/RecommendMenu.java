package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendMenu {

    private final Map<Coach, List<String>> recommendMenu = new HashMap<>();

    private RecommendMenu() {
    }

    public static RecommendMenu createRecommendMenu(Coaches coaches)  {
        RecommendMenu menus = new RecommendMenu();
        List<String> coachNames = coaches.getCoachNames();
        for (String coachName : coachNames) {
            Coach coach = coaches.findByName(coachName);
            List<String> menu = new ArrayList<>();
            menus.recommendMenu.put(coach, menu);
        }
        return menus;
    }

    public List<String> getMenus(Coach coach) {
        return recommendMenu.get(coach);
    }

    public boolean containMenu(Coach coach, String menu){
        List<String> menus = recommendMenu.get(coach);
        return menus.contains(menu);
    }

    public void addRecommendMenu(Coach coach, String menu) {
        List<String> menus = recommendMenu.get(coach);
        menus.add(menu);
    }
}
