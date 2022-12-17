package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Food;
import menu.repository.CoachRepository;
import menu.repository.NotEatFoodRepository;
import menu.view.dto.NotEatFoodsDTO;

public class NotEatFoodService {

    public static void addNotEatFoods(NotEatFoodsDTO notEatFoodDTO) {
        Coach findCoach = CoachRepository.findCoachByName(notEatFoodDTO.getName())
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 코치를 찾을 수 없습니다."));
        List<Food> foods = notEatFoodDTO.getNotEatFoods()
                .stream()
                .map(foodName -> new Food(foodName))
                .collect(Collectors.toList());
        NotEatFoodRepository.addNotEatFoods(findCoach, foods);
    }

}
