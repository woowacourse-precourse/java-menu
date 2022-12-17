package menu.service;

import menu.repository.MenuRepository;

public class MenuService {
    public void validateMenuExist(String name) {
        if (!MenuRepository.menuExist(name)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. :" + name);
        }
    }
}
