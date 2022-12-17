package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.util.ExceptionMessage;

public class CategoryRepository {
    public static final int MAX_SAME_CATEGORY = 2;

    private CategoryRepository() {
    }

    private static final List<Category> categories = new ArrayList<>();
    private static final List<Category> categoriesAlreadyEaten = new ArrayList<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static void addCategoryCount(Category category) {
        categoriesAlreadyEaten.add(category);
    }

    public static Category findByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_CATEGORY.getMessage()));
    }

    public static boolean isAvailableCategory(Category category) {
        return countCategoryOf(category) < MAX_SAME_CATEGORY;
    }

    private static int countCategoryOf(Category category) {
        return (int) categoriesAlreadyEaten.stream()
                .filter(element -> element == category).count();
    }

    public static Category pickRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5) - 1);
    }

    public static List<Category> getCategoriesAlreadyEaten() {
        return Collections.unmodifiableList(categoriesAlreadyEaten);
    }

}
