package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.repository.MenuRepository;

import java.util.List;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void saveCategoryAndMenus(Category category, List<String> menuNames) {
        menuRepository.saveCategoryAndMenu(category, menuNames);
    }


}
