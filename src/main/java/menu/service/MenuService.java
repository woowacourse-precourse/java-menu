package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuService {

    public Menu selectMenu(Coach coach, Category category) {
        while (true) {
            List<String> dislikeFood = coach.getDislikeFood();
            List<Menu> recommendedMenu = coach.getRecommendedMenus();

            List<Menu> menus = Menu.getMenusByCategory(category);

            menus = Randoms.shuffle(menus);
            Menu menu = menus.get(0);

            if (dislikeFood.contains(menu.getName()) || recommendedMenu.contains(menu)) {
                continue;
            }

            return menu;
        }
    }
}
