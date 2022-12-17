package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.history.RecommendHistory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private final Map<String, List<String>> hateMenusByCoach;
    private final RecommendHistory history;

    public MenuRecommender(Map<String, List<String>> hateMenusByCoach, RecommendHistory history) {
        this.hateMenusByCoach = hateMenusByCoach;
        this.history = history;
    }

    public Map<String, String> recommendByCoach(Category category) {
        Map<String, String> recommendedMenuByCoach = new LinkedHashMap<>();
        for (String coachName : hateMenusByCoach.keySet()) {
            String menu = recommend(category, coachName);
            recommendedMenuByCoach.put(coachName, menu);
        }
        return recommendedMenuByCoach;
    }

    private String recommend(Category category, String coachName) {
        String menu;
        List<String> menus = category.getMenus();
        do {
            menu = Randoms.shuffle(menus).get(0);
        } while (isHateMenu(coachName, menu) && !history.canRecommend(coachName, menu));
        return menu;
    }

    private boolean isHateMenu(String coachName, String menu) {
        List<String> hateMenus = hateMenusByCoach.get(coachName);
        return hateMenus.contains(menu);
    }
}
