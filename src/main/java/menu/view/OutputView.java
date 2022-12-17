package menu.view;

import menu.domain.Coach;
import menu.domain.Food;

import java.util.List;

import static menu.utils.ViewMessage.*;

public class OutputView {
    public static void printMenuRecommendationStart() {
        System.out.println(MENU_RECOMMENDATION_START);
    }

    public static void printRecommendationResult(List<Coach> coaches) {
        System.out.println(PRINT_RECOMMENDATION_RESULT);
        for (Coach coach : coaches) {
            System.out.print(PRINT_SQUARE_BRACKETS_START);
            System.out.print(coach.getName());
            for (Food food : coach.getThisWeekFoods()) {
                System.out.print(PRINT_SEPARATOR);
                System.out.print(food.getName());
            }
            System.out.println(PRINT_SQUARE_BRACKETS_END);
        }
    }

    public static void printMenuRecommendationEnd() {
        System.out.println(MENU_RECOMMENDATION_END);
    }
}
