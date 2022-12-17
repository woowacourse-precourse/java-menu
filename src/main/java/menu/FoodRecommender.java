package menu;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class FoodRecommender {
    private int dayCount;
    private final Map<String, Integer> categoryCount;

    FoodRecommender() {
        dayCount = 0;
        categoryCount = new HashMap<>();
        for (String categoryI : FoodPool.category) {
            categoryCount.put(categoryI, 0);
        }
    }

    public String[] recommend(Coach[] coaches) {
        String[] categories = new String[5];
        while (dayCount < 5) {
            String category = pickCategory();
            categories[dayCount] = category;
            for (Coach coach: coaches) {
                pickMenu(coach, category);
            }
            dayCount++;
        }
        return categories;
    }


    public void pickMenu(Coach coach, String category) {
        String newMenu;
        while (true) {
            newMenu = Randoms.shuffle(Arrays.asList(FoodPool.foods.get(category))).get(0);
            if (!coach.checkIsAteMenu(newMenu) && !coach.checkIsHateMenu(newMenu)) break;
        }
        coach.addAteMenus(newMenu);
    }

    public String pickCategory() {
        String newCategory;
        while (true) {
            newCategory = FoodPool.category[Randoms.pickNumberInRange(1, 5) - 1];
            if (checkCategory(newCategory)) break;
        }
        categoryCount.replace(newCategory, categoryCount.get(newCategory) + 1);
        return newCategory;
    }

    private boolean checkCategory(String newCategory) {
        return categoryCount.get(newCategory) <= 1;
    }
}
