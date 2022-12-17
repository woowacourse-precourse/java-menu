package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuService {

    public String selectMenu(Coach coach, Category category) {
        while (true) {
            List<String> dislikeFood = coach.getDislikeFood();
            List<String> recommendedMenu = coach.getRecommendedMenus();

            List<String> menus = Menu.getMenuNamesByCategory(category);
            menus = Randoms.shuffle(menus);
            String menu = menus.get(0);

            if (dislikeFood.contains(menu) || recommendedMenu.contains(menu)) {
                continue;
            }

            return menu;
        }
    }
}
