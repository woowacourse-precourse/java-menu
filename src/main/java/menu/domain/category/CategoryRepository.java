package menu.domain.category;

import java.util.*;

import static menu.util.Constants.CANNOT_FOUND_CATEGORY;

public class CategoryRepository { // 인터페이스 만들어도 될듯
    private static Map<Integer, Category> categories = new HashMap<>();

    private static final CategoryRepository instance = new CategoryRepository();

    private CategoryRepository() {
    }

    public static CategoryRepository getInstance() {
        return instance;
    }

    public Category save(int id, Category category) {
        categories.put(id, category);
        return category;
    }

    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    public Category findById(int id) {
        return Optional.ofNullable(categories.get(id))
                .orElseThrow(() -> new IllegalArgumentException(CANNOT_FOUND_CATEGORY));
    }
}
