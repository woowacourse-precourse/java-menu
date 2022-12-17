package menu.service;


import menu.domain.CategoryForDay;

public class MenuService {

    private final CategoryForDay categoryForDay;

    public MenuService(CategoryForDay categoryForDay) {
        this.categoryForDay = categoryForDay;
    }

    public void selectCategoryForEachDay() {
        categoryForDay.setCategories();
    }


}
