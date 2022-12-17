package menu.repository;

import menu.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryRepository {
    private static class InstanceHolder {
        private static final CategoryRepository INSTANCE = new CategoryRepository();
    }

    private List<Category> categories;

    private CategoryRepository() {
        categories = new ArrayList<>();
    }

    public static CategoryRepository getInstance() {
        return CategoryRepository.InstanceHolder.INSTANCE;
    }

    public boolean isValidCategory(String categoryName) {
        return categories.stream().anyMatch(category -> categoryName.equals(category.getName()));
    }

    public List<String> findAllCategories() {
        return categories.stream().map(Category::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
