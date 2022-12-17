package view;

import constant.Category;
import constant.Week;
import menu.Coach;
import repository.MenuForWeekRepository;

import java.util.Arrays;
import java.util.HashMap;
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

    private String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }

    private void print(String value) {
        System.out.print(value);
    }

    private void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public void printInfo(String value) {
        println("[INFO] " + value);
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

    public void printMenuResult(HashMap<Coach, List<String>> menuResult) {
        // TODO : 출력 메소드 바꿔보기 (지저분함)
        printNewLine();
        println(MENU_RECOMMENDATION_RESULT_TITLE);
        println(WEEKDAYS);
        LinkedHashMap<Week, Category> categoriesPerWeek = MenuForWeekRepository.getCategoriesPerWeek();
        String categories = categoriesPerWeek.values().stream()
                .map(category -> category.getName()).collect(Collectors.joining(" | "));
        println("[ 카테고리 | " + categories + " ]");
        for (Coach coach : menuResult.keySet()) {
            String menus = menuResult.get(coach).stream().collect(Collectors.joining(" | "));
            println("[ " + coach.getName() + " | " + menus + " ]");
        }
        printNewLine();
        println(FINISH_MESSAGE);
    }
}
