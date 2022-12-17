package menu.view;

import static menu.constant.OutputViewConstants.*;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printRecommendedResult(List<Category> recommendedCategories, Coaches coaches) {
        System.out.println(RECOMMEND_RESULT_MESSAGE);
        List<String> categories = new ArrayList<>();
        categories.add(CATEGORY);
        recommendedCategories.stream().forEach(category -> categories.add(category.getName()));
        printCategoriesResult(categories);
        coaches.getCoaches().stream().forEach(OutputView::printCoachResult);
    }

    private static void printCategoriesResult(List<String> categories) {
        System.out.print(OPEN_BRACKET);
        System.out.print(String.join(DELIMITER, categories));
        System.out.println(CLOSE_BRACKET);
    }

    private static void printCoachResult(Coach coach) {
        List<String> menus = new ArrayList<>();
        menus.add(coach.getName());
        menus.addAll(coach.getEatMenu());
        System.out.print(OPEN_BRACKET);
        System.out.print(String.join(DELIMITER, menus));
        System.out.println(CLOSE_BRACKET);
    }
}
