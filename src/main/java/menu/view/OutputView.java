package menu.view;

import menu.domain.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printStartingRecommendation() {
        System.out.println(ViewConstants.STARTING_RECOMMENDATION);
        System.out.println();
    }

    public void printAskingCoachNames() {
        System.out.println(ViewConstants.ASKING_NAME);
        System.out.println();
    }

    public void printAskingInedibleMenus(String coachName) {
        System.out.printf(ViewConstants.ASKING_INEDIBLE_MENU, coachName);
        System.out.println();
    }

    public void printResult(List<String> previousCategories, List<Coach> coaches) {
        System.out.println(ViewConstants.RESULT);
        printStyledRow(ViewConstants.DAYS);
        printCategories(previousCategories);
        coaches.stream()
                .map(Coach::getResult)
                .forEach(this::printStyledRow);

        System.out.println();
    }

    private void printCategories(List<String> previousCategories) {
        previousCategories.add(0, ViewConstants.CATEGORY);
        printStyledRow(previousCategories);
    }

    private void printStyledRow(List<String> row) {
        System.out.println(row.stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK))
        );
    }

    public void printCompletion() {
        System.out.println(ViewConstants.COMPLETION);
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
