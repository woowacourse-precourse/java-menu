package menu.controller;

import menu.domain.CategoryForDay;
import menu.domain.Coach;
import menu.service.MenuService;

public class MenuController {

    private final MenuService menuService;

    public MenuController() {
        this.menuService = new MenuService(new CategoryForDay());
    }

    public void recommendCategory() {
        menuService.selectCategoryForEachDay();
    }
}
