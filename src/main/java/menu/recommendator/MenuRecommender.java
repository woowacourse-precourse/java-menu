package menu.recommendator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.CategoryRecommendation;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.FoodCategory;
import menu.domain.FoodRepository;

public class MenuRecommender {
    public static void recommendMenuOfCoaches(List<Coach> coaches) {
        List<FoodCategory> categoryRecommendation = CategoryRecommendation.getRecommendations();
        for (Coach coach : coaches) {
            recommendMenuOfCoach(coach, categoryRecommendation);
        }
    }

    private static void recommendMenuOfCoach(Coach coach, List<FoodCategory> categoryRecommendation) {
        for (FoodCategory foodCategory : categoryRecommendation) {
            recommendMenuOfDay(coach, foodCategory);
        }
    }

    private static void recommendMenuOfDay(Coach coach, FoodCategory foodCategory) {
        List<String> categorizedFoodNames = FoodRepository.getFoodNamesByCategory(foodCategory);
        while (true) {
            Food pickedMenu = FoodRepository.getFoodByName(Randoms.shuffle(categorizedFoodNames).get(0));
            if (coach.isInedibleFood(pickedMenu) || coach.isAlreadyRecommended(pickedMenu)) {
                continue;
            }
            coach.addRecommendedFood(pickedMenu);
            break;
        }
    }
}
