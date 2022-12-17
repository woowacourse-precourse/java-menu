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
        group.makeMenus();
        outputView.renderResult(group.getCoaches(), group.getCategoryHistory());
    }

    private List<CoachName> readCoachNames() {
        try {
            return inputView.readNames().stream()
                    .map(CoachName::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoachNames();
        }
    }

    private void addCannotEatMenus(CoachName coach) {
        try {
            List<String> cannotEatMenus = inputView.readMenuCantEat(coach.getName());
            group.addCoach(coach, cannotEatMenus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addCannotEatMenus(coach);
        }
    }
}
