package menu.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.dto.Recommendation;

public class OutputView {

    public void printServiceStart() {
        System.out.println(Message.SERVICE_START.getMessage());
    }

    public void printInputCoach() {
        System.out.println();
        System.out.println(Message.INPUT_COACH.getMessage());
    }

    public void printHardToEat(Coach coach) {
        System.out.println();
        System.out.println(String.format(Message.IMPOSSIBLE_TO_EAT.getMessage(), coach.getName()));
    }

    public void printRecommendation(Recommendation recommendation, List<Coach> coaches) {
        System.out.println();
        System.out.println(Message.RECOMMEND_RESULT.getMessage());
        printResult(recommendation, coaches);
        System.out.println();
        System.out.println(Message.RECOMMEND_FINISH.getMessage());
    }

    private void printResult(Recommendation recommendation, List<Coach> coaches) {
        printSort();
        printCategory(recommendation.getCategories());
        printCoachMenus(recommendation.getRecommendation(), coaches);
    }

    private void printSort() {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = getSortJoiner();

        builder.append(Message.PREFIX.getMessage())
                .append(joiner)
                .append(Message.POSTFIX.getMessage());

        System.out.println(builder);
    }

    private StringJoiner getSortJoiner() {
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(Message.SORT.getMessage());

        for (Day day : Day.values()) {
            joiner.add(day.getName());
        }

        return joiner;
    }

    private void printCategory(Map<Day, Category> categories) {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = getCategoryJoiner(categories);

        builder.append(Message.PREFIX.getMessage())
                .append(joiner)
                .append(Message.POSTFIX.getMessage());

        System.out.println(builder);
    }

    private StringJoiner getCategoryJoiner(Map<Day, Category> categories) {
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(Message.CATEGORY.getMessage());

        for (Day day : Day.values()) {
            joiner.add(categories.get(day).getName());
        }

        return joiner;
    }

    private void printCoachMenus(Map<Coach, Map<Day, String>> recommendation, List<Coach> coaches) {
        for (Coach coach : coaches) {
            Map<Day, String> menus = recommendation.get(coach);
            printPerCoach(coach, menus);
        }
    }

    private void printPerCoach(Coach coach, Map<Day, String> menus) {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = getCoachJoiner(coach, menus);

        builder.append(Message.PREFIX.getMessage())
                .append(joiner)
                .append(Message.POSTFIX.getMessage());

        System.out.println(builder);
    }

    private StringJoiner getCoachJoiner(Coach coach, Map<Day, String> menus) {
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(coach.getName());

        for (Day day : Day.values()) {
            joiner.add(menus.get(day));
        }

        return joiner;
    }

    public static void printErrorMessage(String message) {
        System.out.println(String.format(Message.ERROR.getMessage(), message));
    }
}
