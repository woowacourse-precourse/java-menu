package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class CategoryMaker {
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;
    private final int CATEGORY_COUNT = 5;

    public CategoryMaker(CategoryRandomNumberGenerator categoryRandomNumberGenerator) {
        this.categoryRandomNumberGenerator = categoryRandomNumberGenerator;
    }

    public List<Category> makeCategories() {
        List<Category> categories = new ArrayList<>();
        for(int i = 0; i<CATEGORY_COUNT; i++) {
            int randomNumber = categoryRandomNumberGenerator.generate();
            Category category = Category.makeCategory(randomNumber);
            categories.add(category);
        }
        return categories;
    }
}
