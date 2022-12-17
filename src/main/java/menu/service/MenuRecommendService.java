package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.NotEatFoods;
import menu.repository.CategoryGenerator;
import menu.repository.CoachRepository;
import menu.repository.FoodRepository;
import menu.repository.NotEatFoodRepository;

public class MenuRecommendService {

    public static List<Category> run() {
        List<Category> categories = CategoryGenerator.createCategorys();
        List<Coach> allCoach = CoachRepository.findAll();
        for (int i = 0; i < categories.size(); i++) {
            for (Coach coach : allCoach) {
                recommendFood(coach, categories.get(i));
            }
        }
        return categories;
    }

    public static void recommendFood(Coach coach, Category category) {
        while (true) {
            String randomFoodOfCategory = getRandomFoodByCategory(category);
            if (checkNotEatFood(coach, randomFoodOfCategory)) {
                addRecommendFood(coach, randomFoodOfCategory);
                return;
            }
        }
    }

    public static void addRecommendFood(Coach coach, String randomFoodOfCategory) {
        NotEatFoods notEatFoods = NotEatFoodRepository.findByCoach(coach);
        Food recommendedFood = FoodRepository.findFoodByFoodName(randomFoodOfCategory);
        notEatFoods.addNotEatFood(recommendedFood);
        coach.addRecommendFood(recommendedFood);
    }

    public static String getRandomFoodByCategory(Category category) {
        return Randoms.shuffle(category.getFoodNames()).get(0);
    }

    public static boolean checkNotEatFood(Coach coach, String foodName) {
        Food food = FoodRepository.findFoodByFoodName(foodName);
        NotEatFoods notEatFoods = NotEatFoodRepository.findByCoach(coach);
        return notEatFoods.canEat(food);
    }

}
