package menu;

import menu.domain.*;
import menu.domain.food.Category;
import menu.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryController {

    public void makeCoach(String name, List<String> cantEat) {
        validateFood(cantEat);

        Coach coach = new Coach(name, cantEat);
        CoachRepository.save(coach);
    }

    private static void validateFood(List<String> cantEat) {
        for (String foodName : cantEat) {
            if (!FoodRepository.hasFoodName(foodName)) {
                throw new IllegalArgumentException("없는 메뉴를 입력하셨습니다.");
            }
        }
    }


}
