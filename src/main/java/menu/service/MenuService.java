package menu.service;

import menu.domain.Category;
import menu.domain.Menu;
import menu.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository = new MenuRepository();

    public void saveMenuInfo(Category category, List<String> menuNames) {
        Menu menu = new Menu(category, menuNames);
        menuRepository.saveMenu(menu);
    }
}
