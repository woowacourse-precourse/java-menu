package view;

import constant.Category;
import constant.Week;
import menu.Coach;
import repository.MenuForWeekRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {
    private void println(String value) {
        System.out.println(value);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public void printStartMessage() {
        println(START_MESSAGE);
        printNewLine();
    }

    public void printReadingCoachNames() {
        println(READ_COACH_NAMES);
    }

    public void printReadingHateFood(String coachName) {
        printNewLine();
        printFormat(READ_HATE_FOOD, coachName);
        printNewLine();
    }

    public void printMenuResult(LinkedHashMap<Coach, List<String>> menuResult) {
        printNewLine();
        println(MENU_RECOMMENDATION_RESULT_TITLE);
        println(WEEKDAYS);
        println(CATEGORY_START_BRACKET
                        + makeCategoryIntoString(MenuForWeekRepository.getCategoriesPerWeek())
                        + END_BRACKET
        );
        printMenusPerCoaches(menuResult);
        printNewLine();
        println(FINISH_MESSAGE);
    }

    private void printMenusPerCoaches(LinkedHashMap<Coach, List<String>> menuResult) {
        for (Coach coach : menuResult.keySet()) {
            String menus = menuResult.get(coach).stream().collect(Collectors.joining(RESULT_DELIMITER));
            println(START_BRACKET + coach.getName() + RESULT_DELIMITER + menus + END_BRACKET);
        }
    }

    private String makeCategoryIntoString(LinkedHashMap<Week, Category> categoriesPerWeek) {
        return categoriesPerWeek.values().stream()
                .map(category -> category.getName()).collect(Collectors.joining(RESULT_DELIMITER));
    }

}
