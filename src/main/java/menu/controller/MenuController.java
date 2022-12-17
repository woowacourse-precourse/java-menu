package menu.controller;

import java.util.List;
import menu.domain.MenuService;
import menu.domain.vo.CoachMenu;
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
        registerInedibleMenus();
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

    private void registerInedibleMenus() {
        List<String> coachNames = menuService.getCoachNames();
        coachNames.forEach(this::registerInedibleMenusEachCoach);
    }

    private void registerInedibleMenusEachCoach(String coachName) {
        while (true) {
            try {
                List<String> inedibleMenus = inputView.readInedibleMenusOfCoach(coachName);
                menuService.registerInedibleMenusToCoach(coachName, inedibleMenus);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void announceMenuRecommendResult() {
        menuService.recommendMenu();
        List<String> categoriesOfWeek = menuService.getCategoriesOfWeek();
        List<CoachMenu> coachMenus = menuService.getCoachMenus();
        outputView.printTopOfTable(categoriesOfWeek);
        outputView.printMenuRecommendResult(coachMenus);
    }
}
