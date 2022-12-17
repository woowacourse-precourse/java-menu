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
    private static final int FIRST = 0;

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
        Food food = pickFoodFrom(category);
        while (wasRecommended(food) || isInedible(food)) {
            food = pickFoodFrom(category);
        }
        recommendedFoods.add(food);
    }

    private Food pickFoodFrom(Category category) {
        String foodName = Randoms.shuffle(Food.foodNamesFromCategory(category)).get(FIRST);
        return Food.from(foodName);
    }

    private boolean isInedible(Food food) {
        return inedibles.contains(food);
    }

    private boolean wasRecommended(Food food) {
        return recommendedFoods.contains(food);
    }

    public List<Food> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFoods);
    }

    public Name getName() {
        return name;
    }
}
