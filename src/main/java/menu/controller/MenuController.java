package menu.controller;

import menu.domain.Category;
import menu.service.CategoryService;
import menu.service.MenuService;
import menu.util.ResourceReader;

import java.util.List;

public class MenuController implements Controller{

    private final MenuService menuService;
    private final ResourceReader resourceReader = new ResourceReader();

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 카테고리별 메뉴에 대해 사전에 정의해둔다.
     */
    @Override
    public void process() {
        for (Category category : Category.values()) {
            List<String> menuNames = Category.getCategoryWithMenus(category, resourceReader);
            menuService.saveCategoryAndMenus(category, menuNames);
        }
    }
}
