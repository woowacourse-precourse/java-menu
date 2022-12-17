package menu.repository;

import menu.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private final static List<Category> categories = new ArrayList<>();

    public void addRecommendedCategories(List<Category> recommendedCategories) {
        recommendedCategories.forEach(category -> categories.add(category));
    }
}
