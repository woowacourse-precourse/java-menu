package menu.controller;

import menu.domain.Coach;
import menu.domain.Group;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Group group = new Group();

    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다");
        List<String> coaches = inputView.readNames();

        for (String coach : coaches) {
            List<String> cannotEatMenus = inputView.readMenuCantEat(coach);
            group.addCoach(coach, cannotEatMenus);
        }

        group.makeMenus();

        outputView.renderResult(group.getCoaches(), group.getCategoryHistory());
    }
}
