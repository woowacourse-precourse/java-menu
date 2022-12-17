package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Menu;
import menu.model.MenuRepository;

public class RecommendController {
    private static final int DAYS = 5;
    private final MenuRepository menuRepository;

    public RecommendController() {
        menuRepository = new MenuRepository();
        menuRepository.readMenu();
    }

    public Menu recommendMenuByCategory(Category category) {
        List<Menu> menuByThisCategory = menuRepository.getMenusByCategory(category);
        List<String> menuNamesByThisCategory = menuByThisCategory.stream()
                .map(v -> v.getName())
                .collect(Collectors.toList());
        String menu = Randoms.shuffle(menuNamesByThisCategory).get(0);
        return menuRepository.getMenuByName(menu);
    }

    public List<Category> getFiveCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < DAYS;) {
            Category tmpCategory = Category.byNumber(Randoms.pickNumberInRange(1, 5));
            if (isMoreThanTwo(categories, tmpCategory)) {
                continue;
            }
            categories.add(tmpCategory);
            i++;
        }
        return categories;
    }

    private boolean isMoreThanTwo(List<Category> categories, Category newCategory) {
        int frequency = Collections.frequency(categories, newCategory);
        if (frequency > 2) {
            return true;
        }
        return false;
    }
}
