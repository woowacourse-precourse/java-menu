package menu.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static menu.enums.Foods.*;

public class CategoryService {

    private static final Integer CATEGORY_COUNT = 5;
    private static final Integer CATEGORY_LIMITED = 2;
    private static final Integer CATEGORY_RANGED_START = 1;
    private static final Integer CATEGORY_RANGED_END = 5;
    private static final List<String> foods = List.of(JAPAN.getName(), KOREA.getName(), CHINA.getName(), ASIAN.getName(), WESTERN.getName());

    private final List<String> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
        choiceCategories();
    }

    public List<String> getCategories() {
        return categories;
    }

    private void choiceCategories() {
        while (categories.size() < CATEGORY_COUNT) {
            String category = getCategory();
            if (isValidCategory(category)) {
                categories.add(category);
            }
        }
    }

    private boolean isValidCategory(String category) {
        return findCategoryCount(category) < CATEGORY_LIMITED;
    }

    private String getCategory() {
        int num = Randoms.pickNumberInRange(CATEGORY_RANGED_START, CATEGORY_RANGED_END);
        return foods.get(num - 1);
    }

    private int findCategoryCount(String category) {
        return (int) this.categories.stream()
                .filter(it -> isEqualCategory(it, category)).count();
    }

    private boolean isEqualCategory(String category, String name) {
        return Objects.equals(category, name);
    }
}
