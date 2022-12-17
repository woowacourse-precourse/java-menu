package menu.service;

import menu.constants.Category;
import menu.model.Coach;
import menu.model.SelectCategory;
import menu.model.SelectMenu;
import menu.util.RandomCategoryValueGenerator;
import menu.util.RandomMenuValueGenerator;

public class MenuRecommendService {
    private static final int WEEK = 7;
    private SelectCategory selectCategory = new SelectCategory();


    public void selectWeekCategory() {
        for (int i = 0; i < WEEK; i++) {
            selectCategory.addCategory(selectCategory());
        }
    }

    private Category selectCategory() {
        boolean categoryState = true;
        Category category = null;

        while (categoryState) {
            category = new RandomCategoryValueGenerator().generate();
            categoryState = selectCategory.isFrequencyMoreThanTwo(category);
        }

        return category;
    }

    public SelectMenu selectWeekMenu(Coach coach) {
        SelectMenu selectMenu = new SelectMenu();
        for (Category category : selectCategory.getSelectCategories()) {
            selectMenu.addMenu(selectMenu(selectMenu, category, coach));
        }

        return selectMenu;
    }

    private String selectMenu(SelectMenu selectMenu, Category category, Coach coach) {
        boolean selectMenuState = true;
        String menu = null;

        while (selectMenuState) {
            menu = new RandomMenuValueGenerator().generate(category);
            selectMenuState = selectMenu.isAlreadyExist(menu) || coach.isHateMenu(menu);
        }

        return menu;
    }
}
