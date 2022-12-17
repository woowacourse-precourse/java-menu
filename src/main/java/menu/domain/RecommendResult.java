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
    }

    public void makeRecommendResult() {
        generateRandomCategories();
        generateRandomMenus();
    }

    private void generateRandomCategories() {
        CategoryMaker categoryMaker = new CategoryMaker(categoryRandomNumberGenerator);
        this.categories = categoryMaker.makeCategories();
    }

    private void generateRandomMenus() {
        for(Category category : categories) {
            MenuMaker menuMaker = new MenuMaker(coaches, category);
            menuMaker.makeRandomMenus();
        }
    }

    public List<Category> getCategories() {
        return categories;
    }
}
