package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.repository.MenuRepository;

import java.util.List;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void saveCategoryAndMenus(Category category, List<String> menuNames) {
        menuRepository.saveCategoryAndMenu(category, menuNames);
    }

    public String getRecommendMenu(Category findCategory) {
        List<String> menus = menuRepository.findMenusByCategory(findCategory);
        return Randoms.shuffle(menus).get(0);
    }

    public boolean isAlreadyRecommend(Coach coach, String recommendMenu) {
        return menuRepository.checkAlreadyRecommendByCoach(coach, recommendMenu);
    }
}
