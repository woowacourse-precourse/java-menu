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
                if (category.equals(Category.EMPTY)) {
                    continue;
                }
                String categoryName = category.getCategoryName();
                put(categoryName, 0);
            }
        }};
        coaches = new ArrayList<>();
        menuRecommend = new MenuRecommend();
        selectedCategory = new ArrayList<>();
    }

    public void run() {
        // start 부분

        for (int i = 0; i < 5; i++) {
            String category = selectCategory();
            // 코치들에게 메뉴를 선정하도록 하는 메서드
        }

        // 결과 출력
    }



    public String selectCategory() {
        String category;
        boolean isSelect;
        do {
            category = menuRecommend.selectCategory();
            isSelect = validateCategory(category);
        } while (!isSelect);
        Integer countOfSelect = countOfCategorySelected.get(category);
        countOfCategorySelected.put(category, countOfSelect+1);
        selectedCategory.add(category);
        return category;
    }

    private boolean validateCategory(String category) {
        return countOfCategorySelected.get(category) < 2;
    }

    public String selectMenu(Coach coach, String category) {
        String menu;
        List<String> menus = Category.getMenus(category);
        boolean isSelect;
        do {
            menu = menuRecommend.selectMenu(menus);
            isSelect = validateMenu(coach, menu);
        } while (!isSelect);
        coach.addfoodEaten(menu);
        return menu;
    }

    private boolean validateMenu(Coach coach, String menu) {
        boolean isEat = coach.isEat(menu);
        return isEat;
    }
}
