package menu;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;
import menu.constant.Food;

public class Coach {

    private final String name;
    private final List<Category> recommendedCategories;
    private final List<Food> recommendedFoods;

    public Coach(String name) {
        this.name = name;
        this.recommendedCategories = new ArrayList<>();
        this.recommendedFoods = new ArrayList<>();
    }

    public void getRecommended() {
        Category category = Category.from(Randoms.pickNumberInRange(1, 5));
        while (isRecommendedTwice(category)) {
            category = Category.from(Randoms.pickNumberInRange(1, 5));
        }
        recommendedCategories.add(category);
        String foodName = pickFoodNameFrom(category);
        while (isRecommended(foodName)) {
            foodName = pickFoodNameFrom(category);
        }
        recommendedFoods.add(Food.from(foodName));
    }

    private String pickFoodNameFrom(Category category) {
        return Randoms.shuffle(Food.foodNamesFromCategory(category)).get(0);
    }

    private boolean isRecommendedTwice(Category category) {
        long count = recommendedCategories.stream()
                .filter(element -> element.equals(category))
                .count();
        return count == 2;
    }

    private boolean isRecommended(String foodName) {
        long count = recommendedFoods.stream()
                .filter(element -> element.equals(Food.from(foodName)))
                .count();
        return count != 0;
    }

    public List<Food> getRecommendedFoods() {
        return recommendedFoods;
    }
}
