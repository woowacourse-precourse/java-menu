package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecommendCategoryMaker {

    private final static int CATEGORY_COUNT = 5;
    private final static int MAX_DUPLICATE_CATEGORY_COUNT = 2;

    private final CategoryGenerator categoryGenerator;

    public RecommendCategoryMaker(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public List<Category> make() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < CATEGORY_COUNT) {
            Category category = categoryGenerator.generate();
            if (Collections.frequency(categories, category) < MAX_DUPLICATE_CATEGORY_COUNT) {
                categories.add(category);
            }
        }
        return categories;
    }
}
