package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;

import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private final Map<String, List<String>> hateMenusByCoach;

    public MenuRecommender(Map<String, List<String>> hateMenusByCoach) {
        this.hateMenusByCoach = hateMenusByCoach;
    }

    public String recommend(Category category) {
        List<String> menus = category.getMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
