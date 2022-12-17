package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.CategoryPicker;

public class RecommendedCategory {
    private List<String> categories;

    public RecommendedCategory() {
        this.categories = new ArrayList<>();
        pickRandomCategories();
    }

    //이 주의 모든 요일 각각의 추천 메뉴 반환
    public List<List<String>> getAllFoodsInCategoryForWeek() {
        return categories.stream()
                .map(InitialMenu::getFoodsInCategory)
                .collect(Collectors.toList());
    }

    public List<String> getCategories() {
        return categories;
    }

    private void pickRandomCategories() {
        while (categories.size() < 5) {
            addDailyCategory(CategoryPicker.pickCategory());
        }
    }

    private void addDailyCategory(String category) {
        if (isAbleToAdd(category)) {
            categories.add(category);
        }
    }

    private boolean isAbleToAdd(String category) {
        return (int) categories.stream()
                .filter(name -> name.equals(category))
                .count() < 2;
    }
}
