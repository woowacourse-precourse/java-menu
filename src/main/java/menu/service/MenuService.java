package menu.service;

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

}
