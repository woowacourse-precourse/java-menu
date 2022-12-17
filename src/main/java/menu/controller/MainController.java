package menu.controller;

import menu.service.MainService;
import menu.util.ExceptionHandler;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.List;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ExceptionHandler exceptionHandler = new ExceptionHandler(outputView);
    private final MainService mainService = new MainService(exceptionHandler);

    public void run() {
        outputView.printStart();
        List<String> coachNames = exceptionHandler.repeat(inputView::readNames);
        mainService.generateCoaches(coachNames);

        for (String coachName : coachNames) {
            exceptionHandler.process(this::setCantEatMenus, coachName);
        }

        mainService.recommend();
    }

    private void setCantEatMenus(String coachName) {
        outputView.printCoachCantEat(coachName);
        List<String> cantEatMenus = exceptionHandler.repeat(inputView::readCantEatMenu);
        mainService.setCantEatMenus(cantEatMenus, coachName);
    }
}
