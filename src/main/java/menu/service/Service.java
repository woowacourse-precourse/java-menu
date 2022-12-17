package menu.service;

import menu.domain.MenuRepository;

public class Service {
    public void setMenus() {
        MenuRepository.initialize();
    }
}
