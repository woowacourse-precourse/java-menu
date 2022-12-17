package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.utils.Generator;
import menu.utils.Menu;

import java.util.List;

import static menu.utils.Constant.WEEK_LENGTH;

public class MenuService {
    private final Generator generator = new Generator();

    public Category recommendMenuFinal(List<Coach> coaches) {
        Category category = totalCategory();
        for (Menu menu : category.getMenus()) {
            recommendMenuByDay(coaches, menu);
        }
        return category;
    }

    public void recommendMenuByDay(List<Coach> coaches, Menu menu) {
        for (Coach coach : coaches) {
            selectMenu(coach, menu);
        }
    }

    public Category totalCategory() {
        Category category = new Category();
        for (int i = 0; i < WEEK_LENGTH; i++) {
            selectCategory(category);
        }
        return category;
    }

    private void selectCategory(Category category) {
        boolean result = false;
        while (!result) {
            Menu menu = generator.categoryGenerator();
            result = category.addCategory(menu);
        }
    }

    private void selectMenu(Coach coach, Menu menu) {
        boolean result = false;
        while (!result) {
            String recommendMenu = generator.menuGenerator(menu);
            result = coach.addRecommendMenu(recommendMenu);
        }
    }
}
