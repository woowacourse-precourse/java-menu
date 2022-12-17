package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.exception.CategoryException;

public class CategoryMaker {
    private final CategoryRandomNumberGenerator categoryRandomNumberGenerator;
    private final int CATEGORY_COUNT = 5;
    private final long CATEGORY_DUPLICATE_LIMIT = 1L;

    public CategoryMaker(CategoryRandomNumberGenerator categoryRandomNumberGenerator) {
        this.categoryRandomNumberGenerator = categoryRandomNumberGenerator;
    }

    public List<Category> makeCategories() {
        List<Category> categories = new ArrayList<>();
        for(int i = 0; i<CATEGORY_COUNT; i++) {
            Category category = makeCategory(categories);
            categories.add(category);
        }
        return categories;
    }

    public Category makeCategory(List<Category> categories) {
        try {
            Category category = generateRandomCategory();
            validateCategory(category, categories);
            return category;
        } catch (IllegalStateException e) {
            return makeCategory(categories);
        }
    }

    private Category generateRandomCategory() {
        int randomNumber = categoryRandomNumberGenerator.generate();
        Category category = Category.makeCategory(randomNumber);
        return category;
    }
    public void validateCategory(Category uncheckedCategory, List<Category> categories) {
        long count = categories.stream()
                .filter(value -> value.equals(uncheckedCategory))
                .count();
        if(count > CATEGORY_DUPLICATE_LIMIT) {
            throw new IllegalStateException(CategoryException.OUT_OF_DUPLICATE_LIMIT.getExceptionMessage());
        }
    }
}
