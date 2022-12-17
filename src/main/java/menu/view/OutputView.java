package menu.view;

import menu.Category;
import menu.Coach;
import menu.Week;

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

    public static void result(Map<Coach, List<String>> recommend) {
        printDivision();
        printCategory();
        for (Coach coach : recommend.keySet()) {
            printCoachAndFoods(coach, recommend.get(coach));
        }

    }

    private static void printDivision() {
        StringBuilder division = new StringBuilder("구분");
        for (Week week : Week.values()) {
            division.append(week.getValue()).append(" | ");
        }
        System.out.println(division);
    }

    private static void printCategory() {
        StringBuilder category = new StringBuilder("카테고리");
        for (Category c : Category.values()) {
            category.append(c.getCategoryName()).append(" | ");
        }
        System.out.println(category);
    }

    private static void printCoachAndFoods(Coach coach, List<String> foods) {
        StringBuilder sb = new StringBuilder(coach.getName());
        for (String food : foods) {
            sb.append(food).append(" | ");
        }
        System.out.println(sb);
    }
}
