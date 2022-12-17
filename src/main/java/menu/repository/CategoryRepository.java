package menu.repository;

import menu.enums.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();

    public CategoryRepository() {
    }

    public void save(Category category) {
        categories.add(category);
        System.out.println(category);
    }

    public int countByCategory(Category category) {
        return Collections.frequency(categories, category);
    }
}
