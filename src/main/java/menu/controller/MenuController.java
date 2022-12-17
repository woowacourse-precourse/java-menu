package menu.controller;

import java.util.List;
import java.util.Map;
import menu.domain.coach.entity.Coach;
import menu.domain.menu.entity.Menu;
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

    public boolean process() {
        try {
            Map<Coach, List<Menu>> coachListMap = menuService.recommendLunchMenus();
            RecommendMenusDto dto = new RecommendMenusDto(coachListMap);
            outputView.recommendLunchMenu(dto);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
