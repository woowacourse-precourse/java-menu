package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.CategoryMaker;
import menu.CategoryRandomNumberGenerator;
import menu.MenuMaker;

public class RecommendResult {
    private final List<Coach> coaches;
    private List<Category> categories;
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;

    public RecommendResult(List<Coach> coaches, CategoryRandomNumberGenerator categoryRandomNumberGenerator) {
        this.coaches = coaches;
        this.categories = new ArrayList<>();
        this.categoryRandomNumberGenerator = categoryRandomNumberGenerator;
        makeRecommendResult();
    }

    private void makeRecommendResult() {
        generateRandomCategories();
        generateRandomMenus();
    }

    private void generateRandomCategories() {
        CategoryMaker categoryMaker = new CategoryMaker(categoryRandomNumberGenerator);
        this.categories = categoryMaker.makeCategories();
    }

    private void generateRandomMenus() {
        for(Coach coach : coaches) {
            MenuMaker menuMaker = new MenuMaker(coach, categories);
            List<Menu> coachMenus = menuMaker.makeRandomMenus();
            coach.setRecommendMenus(coachMenus);
        }
    }

}
