package menu.service;

import menu.model.Menu;
import menu.repository.MenuRepository;

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
}
