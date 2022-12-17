package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.service.MenuService;

public class PickingMenu {

    MenuService menuService;

    public PickingMenu() {
        menuService = new MenuService();
    }

    public Menu getMenuByShuffle(Category category) {
        List<String> menuNames = menuService.getMenusByCategoryToShuffle(category);
        String menuName = Randoms.shuffle(menuNames).get(0);
        return menuService.getMenuByMenuName(menuName);
    }
}
