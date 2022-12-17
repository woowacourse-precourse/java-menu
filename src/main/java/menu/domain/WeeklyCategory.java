package menu.domain;

import static menu.domain.constant.MenuRule.MAXIMUM_CATEGORY_FREQUENCY;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
                .forEach(day -> {
                    addRandomCategoryOfDay(day);
                });
    }

    private void addRandomCategoryOfDay(Day day) {
        Category category;
        do {
            category = Category.getRandomCategory();
        } while (canAddCategory(category));
        dayCategories.put(day, category);
    }

    private boolean canAddCategory(Category category) {
        List<Category> existCategories = Arrays.asList(dayCategories.keySet()).stream()
                .map(key -> dayCategories.get(key))
                .collect(Collectors.toList());
        int countOfCategory = Collections.frequency(existCategories, category);
        if (countOfCategory >= MAXIMUM_CATEGORY_FREQUENCY) {
            return false;
        }
        return true;
    }
}
