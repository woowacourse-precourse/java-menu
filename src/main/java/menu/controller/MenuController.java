package menu.controller;

import menu.domain.Coaches;
import menu.domain.PickCategory;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.function.Supplier;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuService = menuService;
    }

    public void run() {
        outputView.startMessage();
        Coaches coaches = getCoachesName();
        getNotEatableName(coaches);
        PickCategory pickCategory = menuService.recommendCategory();
        menuService.pickRecommendMenu(coaches, pickCategory);
        outputView.printMenu(coaches, pickCategory);
    }

    public Coaches getCoachesName() {
        outputView.getCoachesName();
        return repeat(inputView::getCoachesName);
    }

    public void getNotEatableName(Coaches coaches) {
        try {
            inputView.getNotEatableMenu(coaches);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            getNotEatableName(coaches);
        }
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
