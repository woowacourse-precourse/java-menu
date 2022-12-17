package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.CategoryMaker;
import menu.CategoryRandomNumberGenerator;

public class RecommendResult {
    private List<Coach> coaches;
    private List<Category> categories;
    private CategoryRandomNumberGenerator categoryRandomNumberGenerator;

    public RecommendResult(List<Coach> coaches, CategoryRandomNumberGenerator categoryRandomNumberGenerator) {
        this.coaches = coaches;
        this.categories = new ArrayList<>();
        this.categoryRandomNumberGenerator = categoryRandomNumberGenerator;
    }

    private void generateRandomCategories() {
        CategoryMaker categoryMaker = new CategoryMaker(categoryRandomNumberGenerator);
        this.categories = categoryMaker.makeCategories();
    }

}
