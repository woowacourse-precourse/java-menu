package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private final CoachService coachService = new CoachService();

    public void recommendMenus(List<Category> categories, List<Coach> coaches) {
        coaches.forEach(coach -> {
            List<Menu> recommendMenus = generateRecommendMenuList(categories);
            coachService.inputRecommendedMenus(coach, recommendMenus);
        });
    }

    public List<Menu> generateRecommendMenuList(List<Category> categories) {
        List<Menu> recommendMenus = new ArrayList<>();
        categories.forEach(category -> {
            List<Menu> menus = Menu.getAllMenuOfCategory(category);
            Menu recommendMenu = Randoms.shuffle(menus).get(0);
            recommendMenus.add(recommendMenu);
        });

        return recommendMenus;
    }
}
