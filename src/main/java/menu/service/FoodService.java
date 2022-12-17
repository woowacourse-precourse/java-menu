package menu.service;

import java.util.List;
import menu.domain.Food;
import menu.repository.FoodRepository;

public class FoodService {

    private final FoodRepository foodRepository = FoodRepository.getInstance();

    public void addFood(String foodName) {
        foodRepository.addFood(new Food(foodName));
    }

    public void findFoodsByFoodNames(List<String> foodNames) {

    }

}
