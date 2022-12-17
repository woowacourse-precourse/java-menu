package menu.output;

import java.util.List;
import menu.domain.CategoryRecommendation;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.FoodCategory;

public class ResultOutput {
    private static final String resultMessage = "메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String firstLetterOfLine = "[ ";
    private static final String lastLetterOfLine = " ]";
    private static final String categoryInKorean = "카테고리";
    private static final String delimiter = " | ";
    public static void printResult(List<Coach> coaches) {
        System.out.println();
        System.out.println(resultMessage);
        printRecommendedCategories();
        printCoachesRecommendedFoods(coaches);
    }

    private static void printRecommendedCategories() {
        List<FoodCategory> categoryRecommendations = CategoryRecommendation.getRecommendations();
        System.out.print(firstLetterOfLine + categoryInKorean);
        for (FoodCategory foodCategory : categoryRecommendations) {
            System.out.print(delimiter);
            System.out.print(foodCategory.getName());
        }
        System.out.println(lastLetterOfLine);
    }

    private static void printCoachesRecommendedFoods(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.print(firstLetterOfLine + coach.getName());
            for (Food food : coach.getRecommendedFoods()) {
                System.out.print(delimiter);
                System.out.print(food.getName());
            }
            System.out.println(lastLetterOfLine);
        }
    }
}
