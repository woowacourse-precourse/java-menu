package menu.service;

import menu.constants.Category;
import menu.model.SelectCategory;
import menu.model.SelectMenu;
import menu.util.RandomCategoryValueGenerator;

public class MenuRecommendService {
    private static final int WEEK = 7;
    private SelectCategory selectCategory = new SelectCategory();
    private SelectMenu selectMenu = new SelectMenu();


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
}
