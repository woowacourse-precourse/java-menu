package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import jdk.jfr.Category;
import menu.model.Menu;
import menu.model.MenuCategory;
import menu.repository.MenuRepository;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService() {
        this.menuRepository = MenuRepository.getInstance();
    }

    public Menu findByName(String name) {
        return menuRepository.findByName(name);
    }

    public Menu getRandomMenuByMenuCategory(MenuCategory menuCategory) {
        List<Menu> menus = menuRepository.findByCategory(menuCategory);
        return Randoms.shuffle(menus).get(0);

    }
}
