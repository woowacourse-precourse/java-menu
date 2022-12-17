package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.Group;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Group group;

    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void run() {
        System.out.println(START_MESSAGE);
        makeGroup();
        makeMenus();
        outputView.renderResult(group.getMenu());
    }

    private void makeGroup() {
        try {
            List<Coach> coaches = makeCoaches();
            group = new Group(coaches);
            for (Coach coach : coaches) {
                addCannotEatMenus(coach);
            }
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            makeGroup();
        }
    }

    private List<Coach> makeCoaches() {
        try {
            return inputView.readNames()
                    .stream()
                    .map(coachName -> new Coach(new CoachName(coachName)))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return makeCoaches();
        }
    }

    private void addCannotEatMenus(Coach coach) {
        try {
            List<String> cannotEatMenus = inputView.readInedibleMenus(coach.getName());
            group.addInedibleMenus(coach.getName(), cannotEatMenus);
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
