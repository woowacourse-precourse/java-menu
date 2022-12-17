package menu;

import menu.coach.Coach;
import menu.menu.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuRecommendProgram {
    private HashMap<String, Integer> countOfCategorySelected;
    private List<Coach> coaches;
    private MenuRecommend menuRecommend;
    private List<String> selectedCategory;

    public MenuRecommendProgram() {
        countOfCategorySelected = new HashMap<>() {{
            for (Category category: Category.values()) {
                String categoryName = category.getCategoryName();
                put(categoryName, 0);
            }
        }};
        coaches = new ArrayList<>();
        menuRecommend = new MenuRecommend();
        selectedCategory = new ArrayList<>();
    }

    public String selectCategory() {
        String category;
        boolean isSelect;
        do {
            category = menuRecommend.selectCategory();
            isSelect = validateCategory(category);
        } while (isSelect);
        Integer countOfSelect = countOfCategorySelected.get(category);
        countOfCategorySelected.put(category, countOfSelect);
        selectedCategory.add(category);
        return category;
    }

    private boolean validateCategory(String category) {
        return countOfCategorySelected.get(category) < 2;
    }

}
