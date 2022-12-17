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
            List<String> recommendedMenuNames = generateRecommendMenuList(categories);
            coachService.inputRecommendedMenus(coach, getMenusByNames(recommendedMenuNames));
        });
    }

    public List<String> generateRecommendMenuList(List<Category> categories) {
        List<String> recommendMenus = new ArrayList<>();
        categories.forEach(category -> {
            String recommendMenu = Randoms.shuffle(Menu.getAllMenuNamesOfCategory(category)).get(0);
            recommendMenus.add(recommendMenu);
        });

        return recommendMenus;
    }

    private List<Menu> getMenusByNames(List<String> recommendedMenuNames) {
        List<Menu> recommendedMenus = new ArrayList<>();
        recommendedMenuNames.forEach(name ->
                recommendedMenus.add(Menu.findMenuByName(name)));

        return recommendedMenus;
    }
}
