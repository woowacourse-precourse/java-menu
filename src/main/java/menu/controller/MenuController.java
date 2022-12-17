package menu.controller;

import java.util.List;
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
        while (true) {
            try {
                List<String> coachNames = inputView.readCoachNames();
                menuService.generateCoaches(coachNames);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void registerInedibleFoods() {
        List<String> coachNames = menuService.getCoachNames();
        coachNames.forEach(this::registerInedibleFoodsEachCoach);
    }

    private void registerInedibleFoodsEachCoach(String coachName) {
        List<String> inedibleFoods = inputView.readInedibleFoodsOfCoach(coachName);
        menuService.registerInedibleFoodsToCoach(coachName, inedibleFoods);
    }

    private void announceMenuRecommendResult() {

    }
}
