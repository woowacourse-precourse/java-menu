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
        List<CoachName> coaches = inputView.readNames().stream()
                .map(name -> new CoachName(name))
                .collect(Collectors.toList());

        for (CoachName coach : coaches) {
            List<String> cannotEatMenus = inputView.readMenuCantEat(coach.getName());
            group.addCoach(coach, cannotEatMenus);
        }

        group.makeMenus();

        outputView.renderResult(group.getCoaches(), group.getCategoryHistory());
    }
}
