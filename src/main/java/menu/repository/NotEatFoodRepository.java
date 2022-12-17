package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.NotEatFoods;
import menu.util.constants.ExceptionMessage;

public class NotEatFoodRepository {

    private static final List<NotEatFoods> notEatFoodRepository = new ArrayList<>();

    public static NotEatFoods findByCoach(Coach coach) {
        return notEatFoodRepository.stream()
                .filter(notEatFoods -> coach.equals(notEatFoods.getCoach()))
                .findAny()
                .get();
    }

    public static void addInitNotEatFood(NotEatFoods notEatFoods) {
        notEatFoodRepository.add(notEatFoods);
    }

    public static void addNotEatFoods(Coach coach, List<Food> foods) {
        NotEatFoods notEatFoods = notEatFoodRepository.stream()
                .filter(notEatFood -> coach.equals(notEatFood.getCoach()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_FOUND_NOT_EAT_FOODS));

        notEatFoods.addNotEatFoods(foods);
    }

}
