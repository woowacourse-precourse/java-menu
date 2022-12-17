package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.enumeration.Category;
import menu.domain.enumeration.Food;

import java.util.ArrayList;
import java.util.List;

import static menu.domain.enumeration.Food.findFoodPerCategory;

public class CoachFoodRecommand {

    private Coach coach;
    private List<String> foods;

    public static CoachFoodRecommand recommandFood(Coach coach, CategoryRecommand categoryRecommand) {
        List<String> recommandFoods = new ArrayList<String>();
        for (String category : categoryRecommand.categoryPerDay) {
            createRecommandFoodsPerCategory(category, recommandFoods);
        }

        return new CoachFoodRecommand(coach, recommandFoods);
    }

    private static void createRecommandFoodsPerCategory(String category, List<String> recommandFoods) {
        do {
            List<String> foods = getFoodPerCategory(category);
            String food = pickFoodPerCategory(foods);
            boolean isAdded = putRecommandFoods(recommandFoods, food);
            if (isAdded) {
                return;
            }
        } while (true);
    }

    private static boolean putRecommandFoods(List<String> recommandFoods, String food) {
        if (recommandFoods.contains(food)) {
            return false;
        }
        recommandFoods.add(food);
        return true;
    }

    private static String pickFoodPerCategory(List<String> foods) {
        return Randoms.shuffle(foods).get(0);
    }

    private static List<String> getFoodPerCategory(String category) {
        int categoryIndex = Category.findCategoryIndex(category);
        return findFoodPerCategory(categoryIndex);
    }

    private CoachFoodRecommand(Coach coach, List<String> foods) {
        this.coach = coach;
        this.foods = foods;
    }
}
