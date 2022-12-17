package menu.domain.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.util.ExceptionMessage;

public class CategoryRepository {
    private static final int MAX_SAME_CATEGORY = 2;

    private CategoryRepository() {
    }

    private static final List<Category> categories = new ArrayList<>();
    private static final List<Category> categoriesAlreadyEaten = new ArrayList<>();

    public static void add(Category category) {
        categories.add(category);
    }

    public static void addCategoryCount(Category category) {
        categoriesAlreadyEaten.add(category);
    }

    public static Category finCategoryByName(String name) {
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
        return categories.get(getRandomIndex());
    }

    private static int getRandomIndex() {
        return Randoms.pickNumberInRange(Constants.MIN_RANGE.value, Constants.MAX_RANGE.value) - 1;
    }

    public static List<Category> getCategoriesAlreadyEaten() {
        return Collections.unmodifiableList(categoriesAlreadyEaten);
    }

    private enum Constants {
        MIN_RANGE(1), MAX_RANGE(5);

        private final int value;

        Constants(int value) {
            this.value = value;
        }
    }

}
