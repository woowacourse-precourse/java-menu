package menu.service;

import menu.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private void validateMenuExist(String name) {
        if (!MenuRepository.menuExist(name)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. :" + name);
        }
    }

    public void validateMenusExist(List<String> menus) {
        menus.forEach(this::validateMenuExist);
    }
}
