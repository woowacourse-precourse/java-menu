package menu.service;

import menu.constants.Category;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.SelectCategory;
import menu.util.RandomCategoryValueGenerator;
import menu.util.RandomMenuValueGenerator;

public class MenuRecommendService {
    private static final int WEEK = 5;
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

    public Coaches selectWeekMenu(Coaches coaches) {
        for (Category category : selectCategory.getSelectCategories()) {
            selectMenuPerCoach(category, coaches);
        }

        return coaches;
    }

    private Coaches selectMenuPerCoach(Category category, Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            coach.addSelectMenu(selectMenu(category, coach));
        }

        return coaches;
    }

    private String selectMenu(Category category, Coach coach) {
        boolean selectMenuState = true;
        String menu = null;

        while (selectMenuState) {
            menu = new RandomMenuValueGenerator().generate(category);
            selectMenuState = coach.isAlreadyExistMenu(menu) || coach.isHateMenu(menu);
        }

        return menu;
    }

    public SelectCategory getSelectCategory() {
        return selectCategory;
    }
}
