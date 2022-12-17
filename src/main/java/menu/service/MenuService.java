package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menucategory.MenuCategory;
import menu.repository.MenuRepository;
import menu.repository.RecommendCategoryRepository;

import java.util.List;

public class MenuService {
    private static final int NEEDED_CATEGORIES = 5;
    private void validateMenuExist(String name) {
        if (!MenuRepository.menuExist(name)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다. :" + name);
        }
    }

    public void validateMenusExist(List<String> menus) {
        menus.forEach(this::validateMenuExist);
    }

    private void addCategory() {
        List<String> categories = MenuRepository.getCategories();
        String categoryName = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
        MenuCategory category = MenuRepository.getCategoryByName(categoryName);

        if (category.canSelect()) {
            RecommendCategoryRepository.addCategory(category);
            category.select();
            return;
        }
        addCategory();
    }

    public void selectCategories() {
        for (int selectedCount = 0; selectedCount < NEEDED_CATEGORIES; selectedCount++) {
            addCategory();
        }
    }
}
