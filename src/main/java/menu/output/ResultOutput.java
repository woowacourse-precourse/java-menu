package menu.output;

import java.util.List;
import menu.domain.CategoryRecommendation;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Food;
import menu.domain.FoodCategory;
import menu.message.ResultMessage;

public class ResultOutput {
    public static void printResult(List<Coach> coaches) {
        printResultIntroduction();
        printRecommendedCategories();
        printCoachesRecommendedFoods(coaches);
        printFinishMessage();
    }

    private static void printResultIntroduction() {
        System.out.println(ResultMessage.RESULT_INTRODUCTION_MESSAGE.getMessage());
        System.out.print(ResultMessage.HEAD_OF_LINE.getMessage()
                + ResultMessage.CLASSIFICATION.getMessage());
        for (Day day : Day.values()) {
            System.out.print(ResultMessage.DELIMITER.getMessage());
            System.out.print(day.getName());
        }
        System.out.println(ResultMessage.TAIL_OF_LINE.getMessage());
    }

    private static void printRecommendedCategories() {
        List<FoodCategory> categoryRecommendations = CategoryRecommendation.getRecommendations();
        System.out.print(ResultMessage.HEAD_OF_LINE.getMessage()
                + ResultMessage.CATEGORY.getMessage());
        for (FoodCategory foodCategory : categoryRecommendations) {
            System.out.print(ResultMessage.DELIMITER.getMessage());
            System.out.print(foodCategory.getName());
        }
        System.out.println(ResultMessage.TAIL_OF_LINE.getMessage());
    }

    private static void printCoachesRecommendedFoods(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.print(ResultMessage.HEAD_OF_LINE.getMessage() + coach.getName());
            for (Food food : coach.getRecommendedFoods()) {
                System.out.print(ResultMessage.DELIMITER.getMessage() + food.getName());
            }
            System.out.println(ResultMessage.TAIL_OF_LINE.getMessage());
        }
    }

    private static void printFinishMessage() {
        System.out.println();
        System.out.println(ResultMessage.RESULT_FINISH_MESSAGE.getMessage());
    }
}
