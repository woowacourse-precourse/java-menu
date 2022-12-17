package menu.service;

import menu.domain.Category;
import menu.domain.MenuSelector;
import menu.domain.Coach;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    public Menu getMenu(Coach coach, Category category) {
        Menu menu;
        while (true) {
            menu = MenuSelector.getMenu(category);
            if (coach.canEat(menu) && coach.hasNotSameMenu(menu)) {
                break;
            }
        }
        return menu;
    }
}
