package menu.view;

import menu.domain.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printStartingRecommendation() {
        System.out.println(ViewConstants.STARTING_RECOMMENDATION);
        System.out.println();
    }

    public void printCompletion() {
        System.out.println(ViewConstants.COMPLETION);
    }

    public void printResult(List<String> previousCategories, List<Coach> coaches) {
        System.out.println(ViewConstants.RESULT);
        System.out.println(ViewConstants.DAYS);

        previousCategories.add(0, ViewConstants.CATEGORY);
        System.out.println(previousCategories.stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK)));

        coaches.forEach(this::printCoachMenus);
        System.out.println();
        System.out.println(ViewConstants.COMPLETION);
    }

    private void printCoachMenus(Coach coach) {
        System.out.println(coach.getResult().stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK)));
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
