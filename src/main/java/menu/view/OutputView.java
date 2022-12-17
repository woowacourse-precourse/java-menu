package menu.view;

import menu.domain.Coach;

import java.util.stream.Collectors;

public class OutputView {

    public void printStartingRecommendation() {
        System.out.println(ViewConstants.STARTING_RECOMMENDATION);
        System.out.println();
    }

    public void printCompletion() {
        System.out.println(ViewConstants.COMPLETION);
    }

    private void printCoachMenus(Coach coach) {
        System.out.println(coach.getResult().stream()
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.FRONT, ViewConstants.BACK)));
    }
}
