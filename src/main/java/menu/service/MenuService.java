package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.MenuRepository;
import menu.domain.NoEatMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    public List<Category> recommendCategory() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = CategoryRepository.makeRandomCategory(Randoms.pickNumberInRange(0, 4));
            categories.add(category);
        }
        return categories;
    }

    public void recommendMenu(List<Category> categories, NoEatMenu noEatMenu) {
        for (Category category : categories) {
            MenuRepository.makeRandomMenuByCategory(category);
        }
    }
}
