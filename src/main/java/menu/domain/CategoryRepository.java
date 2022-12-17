package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepository {
    public static final int MAX_SAME_CATEGORY = 2;

    private CategoryRepository() {
    }

    private static final List<Category> categories = new ArrayList<>();
    private static final Map<Category, Integer> categoriesCount = new HashMap<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static void addCategoryCount(Category category){
        categoriesCount.put(category, categoriesCount.getOrDefault(category, 0) + 1);
    }

    public static Category findByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static boolean isAvailableCategory(Category category) {
        return categoriesCount.getOrDefault(category, 0) < MAX_SAME_CATEGORY;
    }

    public static Category pickRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5) - 1);
    }
}
