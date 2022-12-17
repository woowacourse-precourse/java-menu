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

    public Category pickDayCategory() {
        Category category = pickCategory();
        List<Coach> coaches = CoachRepository.findAllCoach();

        for (Coach coach : coaches) {
            boolean flag = true;

            while (flag) {
                String randomFood = pickFood(category);
                flag = validateCoachFoods(coach, flag, randomFood);
            }
        }

        return category;
    }

    private static boolean validateCoachFoods(Coach coach, boolean flag, String randomFood) {
        if (!coach.isSameMenu(randomFood) && !coach.isHateMenu(randomFood)) {
            coach.addFood(randomFood); // 코치 정보에 저장
            flag = false;
        }
        return flag;
    }

    private static String pickFood(Category category) {
        List<String> menus = FoodRepository.getMenus(category); //한식의 메뉴들 리스트
        String randomFood = Random.pickRandomFood(menus); // 메뉴들에서 하나 뽑음
        return randomFood;
    }

    private static Category pickCategory() {
        boolean flag = true;

        while (flag) {
            Category category = Random.pickRandomCategory(); // 카테고리 고름 한식

            if (!CategoryRepository.hasSameCategoryMoreThanTwo(category)) { // 한주에 두개 이상인지 확인
                CategoryRepository.save(category);
                return category;
            }
        }

        throw new IllegalArgumentException("카테고리 고르는 것이 불가능합니다.");
    }
}
