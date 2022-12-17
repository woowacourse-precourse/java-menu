package menu.controller;

import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MenuController {
    private final MenuService menuService = new MenuService();
    private final CoachService coachService = new CoachService();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printStartMessage();
        List<String> coachNames = repeat(inputView::getCoachNames);
        coachService.addCoaches(coachNames);
    }

    private <T> T repeat(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return repeat(function);
        }
    }
}
