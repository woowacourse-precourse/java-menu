package menu.domain;

import static menu.domain.constant.MenuRule.MAXIMUM_CATEGORY_FREQUENCY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.constant.Category;
import menu.domain.constant.Day;

public class WeeklyCategory {
    private final Map<Day, Category> dayCategories;

    public WeeklyCategory() {
        this.dayCategories = new LinkedHashMap<>();
        initDayCategories();
    }

    private void initDayCategories() {
        Arrays.stream(Day.values())
                .forEach(this::addRandomCategoryOfDay);
    }

    private void addRandomCategoryOfDay(Day day) {
        Category category;
        do {
            category = Category.getRandomCategory();
        } while (!canAddCategory(category));
        dayCategories.put(day, category);
    }

    private boolean canAddCategory(Category category) {
        List<Category> existCategories = new ArrayList<>(dayCategories.values());
        int countOfCategory = Collections.frequency(existCategories, category);
        if (countOfCategory >= MAXIMUM_CATEGORY_FREQUENCY) {
            return false;
        }
        return true;
    }

    public Category getCategoryOfDay(Day day) {
        return dayCategories.get(day);
    }
}
