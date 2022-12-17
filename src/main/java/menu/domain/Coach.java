package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;
import menu.constant.Food;
import menu.domain.vo.Name;

public class Coach {
    private static final int INEDIBLE_MAXIMUM_SIZE = 2;

    private final Name name;
    private final List<Food> inedibles;
    private final List<Food> recommendedFoods;

    public Coach(String name, List<Food> inedibles) {
        this(new Name(name), inedibles);
    }

    public Coach(Name name, List<Food> inedibles) {
        validateInediblesLength(inedibles);
        this.name = name;
        this.inedibles = inedibles;
        this.recommendedFoods = new ArrayList<>();
    }

    private void validateInediblesLength(List<Food> inedibles) {
        if (inedibles.size() > INEDIBLE_MAXIMUM_SIZE) {
            throw new IllegalArgumentException("못 먹는 음식이 너무 많습니다");
        }
    }

    public void pickFrom(Category category) {
        String foodName = pickFoodNameFrom(category);
        while (wasRecommended(foodName) || isInedible(foodName)) {
            foodName = pickFoodNameFrom(category);
        }
        recommendedFoods.add(Food.from(foodName));
    }

    private String pickFoodNameFrom(Category category) {
        return Randoms.shuffle(Food.foodNamesFromCategory(category)).get(0);
    }

    private boolean isInedible(String foodName) {
        return inedibles.contains(Food.from(foodName));
    }

    private boolean wasRecommended(String foodName) {
        return recommendedFoods.contains(Food.from(foodName));
    }

    public List<Food> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFoods);
    }

    public Name getName() {
        return name;
    }
}
