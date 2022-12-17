package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;

public class MenuService {

    SettingMenu settingMenu;

    public MenuService() {
        settingMenu = new SettingMenu();
    }

    public List<Menu> getMenusByCategory(Category category) {
        return MenuRepository.getMenusByCategory(category);
    }

    public List<String> getMenusByCategoryToShuffle(Category category) {
        List<String> result = new ArrayList<>();
        List<Menu> menus = getMenusByCategory(category);
        for (Menu menu : menus) {
            result.add(menu.getName());
        }
        return result;
    }

    public Menu getMenuByMenuName(String menuName) {
        return MenuRepository.getMenuByMenuName(menuName);
    }
}
