package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.constants.Week;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void start() {
        System.out.println(Messages.START.getMessage());
    }

    public static void inputCoachName() {
        System.out.println(Messages.INPUT_COACH_NAME.getMessage());
    }

    public static void inputInedibleFood(Coach coach) {
        System.out.println(coach.getName() + Messages.INPUT_INEDIBLE_FOOD.getMessage());
    }

    public static void result(List<Coach> coaches, Map<Week, Category> categoryByWeek) {
        System.out.println(Messages.RESULT.getMessage());
        printDivision();
        printCategory(categoryByWeek);
        printFoodsByCoach(coaches);
        System.out.println();
        System.out.println(Messages.COMPLETE_RECOMMEND.getMessage());
    }

    private static void printDivision() {
        StringBuilder division = new StringBuilder("[ 구분 | ");
        for (Week week : Week.values()) {
            division.append(week.getValue()).append(" | ");
        }
        division.replace(division.length() - 2, division.length() - 1, "]");
        System.out.println(division);
    }

    private static void printCategory(Map<Week, Category> categoryByWeek) {
        StringBuilder category = new StringBuilder("[ 카테고리 | ");
        for (Week week : categoryByWeek.keySet()) {
            category.append(categoryByWeek.get(week).getCategoryName()).append(" | ");
        }
        category.replace(category.length() - 2, category.length() - 1, "]");
        System.out.println(category);
    }

    private static void printFoodsByCoach(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printFood(coach);
        }
    }

    private static void printFood(Coach coach) {
        StringBuilder coachAndFoods = new StringBuilder("[ " + coach.getName() + " | ");
        for (String food : coach.getFoods()) {
            coachAndFoods.append(food).append(" | ");
        }
        coachAndFoods.replace(coachAndFoods.length() - 2, coachAndFoods.length() - 1, "]");
        System.out.println(coachAndFoods);
    }

    public static void newLine() {
        System.out.println();
    }
}
