package menu.controller;

import menu.domain.MenuService;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuService = new MenuService();
    }

    public void start() {
        outputView.announceStart();
        generateCoaches();
        registerInedibleFoods();
        announceMenuRecommendResult();
    }

    private void generateCoaches() {

    }

    private void registerInedibleFoods() {

    }

    private void announceMenuRecommendResult() {

    }
}
