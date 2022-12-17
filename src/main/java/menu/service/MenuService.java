package menu.service;


import java.util.List;

import menu.domain.CategoryForDay;

public class MenuService {

    private final CategoryForDay categoryForDay;

    public MenuService(CategoryForDay categoryForDay) {
        this.categoryForDay = categoryForDay;
    }

    public void selectCategoryForEachDay() {
        categoryForDay.setCategories();
    }

    public String getRecommendCategoryWord() {
        return categoryForDay.toString();
    }

    public List<String> getRecommendCategory() {
        return categoryForDay.getCategories();
    }
}
