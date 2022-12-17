package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryMaker {
    Map<Day, Category> categoriesOfDay;
    Map<Category, Integer> categoryCount;

    public CategoryMaker() {
        this.categoriesOfDay = new HashMap<>();
        this.categoryCount = new HashMap<>();
        Arrays.stream(Day.values())
                .forEach(day -> categoriesOfDay.put(day, Category.NOCATEGORY));
    }

    public Map<Day, Category> getCategoriesOfDay() {
        return categoriesOfDay;
    }
    public List<String> getCategoriesName(){
        return this.categoriesOfDay.values().stream()
                .map((Category::getName))
                .collect(Collectors.toList());
    }

    public void makeRandomCategories() {
        for (Day day : categoriesOfDay.keySet()) {
            Category category = Category.findCategoryById(Randoms.pickNumberInRange(1, 5));
            while (validateSameCategory(category)) {
                category = Category.findCategoryById(Randoms.pickNumberInRange(1, 5));
            }
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            categoriesOfDay.put(day, category);
        }

    }

    private boolean validateSameCategory(Category category) {
        long count = categoriesOfDay.entrySet().stream()
                .filter(dayCategoryEntry -> dayCategoryEntry.getValue() == category)
                .count();
        return  count >= 2;
    }
}
