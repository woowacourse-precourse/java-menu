package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.service.MenuService;

public class PickingMenu {

    MenuService menuService;

    PickingMenu() {
        menuService = new MenuService();
    }

    public Menu getMenuByShuffle(Category category) {
        List<Menu> menus = menuService.getMenusByCategory(category);
        return Randoms.shuffle(menus).get(0);
    }
}
