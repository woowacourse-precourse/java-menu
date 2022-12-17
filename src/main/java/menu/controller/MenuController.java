package menu.controller;

import menu.dto.menu.RecommendMenusDto;
import menu.service.menu.MenuService;
import menu.view.menu.MenuOutputView;

public class MenuController {

    private final MenuService menuService;
    private final MenuOutputView outputView;

    public MenuController(MenuService menuService, MenuOutputView outputView) {
        this.menuService = menuService;
        this.outputView = outputView;
    }

    public void process() {
        RecommendMenusDto recommendMenusDto = menuService.recommendLunchMenus();
        outputView.recommendLunchMenu(recommendMenusDto);
    }
}
