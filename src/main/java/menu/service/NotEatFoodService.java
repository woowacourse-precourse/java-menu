package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Food;
import menu.repository.CoachRepository;
import menu.repository.FoodRepository;
import menu.repository.NotEatFoodRepository;
import menu.util.constants.ExceptionMessage;
import menu.view.dto.NotEatFoodsDTO;

public class NotEatFoodService {

    public void addNotEatFoods(NotEatFoodsDTO notEatFoodDTO) {
        Coach findCoach = CoachRepository.findCoachByName(notEatFoodDTO.getName())
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_FOUND_COACH));
        List<Food> foods = FoodRepository.findFoodsByFoodNames(notEatFoodDTO.getNotEatFoods());
        NotEatFoodRepository.addNotEatFoods(findCoach, foods);
    }

}
