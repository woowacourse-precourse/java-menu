package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.NoEatMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    public void recommendMenu(NoEatMenu noEatMenu) {

    }

    public List<Category> recommendCategory() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = CategoryRepository.makeRandomCategory(Randoms.pickNumberInRange(1, 5));
            categories.add(category);
        }
        return categories;
    }
}
