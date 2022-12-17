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
    }

    public void printAskingInedibleMenus(String coachName) {
        System.out.printf(ViewConstants.ASKING_INEDIBLE_MENU, coachName);
        System.out.println();
    }

    public void printResult(List<String> previousCategories, List<Coach> coaches) {
        System.out.println(ViewConstants.RESULT);
        System.out.println(ViewConstants.DAYS);
        printCategories(previousCategories);
        coaches.forEach(this::printCoachMenus);
        System.out.println();
    }

    private void printCategories(List<String> previousCategories) {
        previousCategories.add(0, ViewConstants.CATEGORY);
        System.out.println(previousCategories.stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK)));
    }

    private void printCoachMenus(Coach coach) {
        System.out.println(coach.getResult().stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK)));
    }

    public void printCompletion() {
        System.out.println(ViewConstants.COMPLETION);
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
