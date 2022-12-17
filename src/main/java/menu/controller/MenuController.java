package menu.controller;

import menu.domain.CoachName;
import menu.domain.Group;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Group group = new Group();

    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void run() {
        System.out.println(START_MESSAGE);
        List<CoachName> coaches = readCoachNames();
        for (CoachName coach : coaches) {
            addCannotEatMenus(coach);
        }
        makeMenus();
        outputView.renderResult(group.getMenu());
    }

    private List<CoachName> readCoachNames() {
        try {
            return inputView.readNames().stream()
                    .map(CoachName::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readCoachNames();
        }
    }

    private void addCannotEatMenus(CoachName coach) {
        try {
            List<String> cannotEatMenus = inputView.readMenuCantEat(coach.getName());
            group.addCoach(coach, cannotEatMenus);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            addCannotEatMenus(coach);
        }
    }

    private void makeMenus() {
        try {
            group.makeMenus();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            makeMenus();
        }
    }
}
