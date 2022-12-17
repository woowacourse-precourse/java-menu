package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CategoryRepository {
    private CategoryRepository() {
    }
    private static final List<Category> categories = new ArrayList<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static boolean deleteByName(String name) {
        return categories.removeIf(element -> Objects.equals(element.getName(), name));
    }

    public static void deleteAll() {
        categories.clear();
    }

    public static Category findByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
