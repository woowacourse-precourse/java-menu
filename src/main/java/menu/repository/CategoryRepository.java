package menu.repository;

import menu.domain.Category;

import java.util.ArrayList;
import java.util.List;

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
}
