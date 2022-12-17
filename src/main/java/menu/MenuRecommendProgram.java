package menu;

import menu.coach.Coach;
import menu.menu.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuRecommendProgram {
    private HashMap<String, Integer> countOfCategorySelected;
    private List<Coach> coaches;

    public MenuRecommendProgram() {
        countOfCategorySelected = new HashMap<>() {{
            for (Category category: Category.values()) {
                String categoryName = category.getCategoryName();
                put(categoryName, 0);
            }
        }};
        coaches = new ArrayList<>();
    }

}
