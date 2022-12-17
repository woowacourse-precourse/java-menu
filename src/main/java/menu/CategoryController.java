package menu;

import menu.domain.*;
import menu.domain.food.Category;
import menu.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryController {

    public static final int WEEK = 5;

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

    public List<Category> makeRecommendMenu() {
        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < WEEK; i++) {
            categories.add(pickDayCategory());
        }

        return categories;
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
            coach.addFood(randomFood);
            flag = false;
        }
        return flag;
    }

    private static String pickFood(Category category) {
        List<String> menus = FoodRepository.getMenus(category);
        String randomFood = Random.pickRandomFood(menus);
        return randomFood;
    }

    private static Category pickCategory() {
        boolean flag = true;

        while (flag) {
            Category category = Random.pickRandomCategory();

            if (!CategoryRepository.hasSameCategoryMoreThanTwo(category)) {
                CategoryRepository.save(category);
                return category;
            }
        }

        throw new IllegalArgumentException("카테고리 고르는 것이 불가능합니다.");
    }

    public List<String> getRecommendMenus(String name) {
        Coach coach = CoachRepository.findCoachByName(name);
        List<String> foods = coach.getFoods();
        return foods;
    }

    public List<String> getCategoryNames(List<Category> categories) {
        return categories.stream()
                .map(category -> category.getName())
                .collect(Collectors.toList());
    }

}
