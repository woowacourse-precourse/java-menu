package menu.controller;

import menu.domain.Category;
import menu.domain.Menu;
import menu.service.MenuService;
import menu.util.ResourceReader;

import java.util.List;

public class MenuController implements Controller{

    private final MenuService menuService = new MenuService();
    private final ResourceReader resourceReader = new ResourceReader();

    /**
     * 카테고리별 메뉴에 대해 사전에 정의해둔다.
     */
    @Override
    public void process() {
        for (Category category : Category.values()) {
            List<String> menuNames = Category.getCategoryWithMenus(category, resourceReader);
            menuService.saveMenuInfo(category, menuNames);
        }
    }
}
