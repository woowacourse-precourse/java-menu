package menu.controller;

import menu.domain.CoachInfo;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();
    public void run() {
        CoachInfo coachInfo = settingInfo();
        menuService.recommendMenu(coachInfo);
        finishRecommendMenu(coachInfo);
    }

    private CoachInfo settingInfo() {
        outputView.printStartMessage();
        CoachInfo coachInfo = settingCoachName();
        for (String coachName : coachInfo.getCoachNames()) {
            settingForbiddenFood(coachInfo, coachName);
        }
        return coachInfo;
    }

    private CoachInfo settingCoachName() {
        try {
            return inputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return settingCoachName();
        }
    }

    private void settingForbiddenFood(CoachInfo coachInfo, String coachName) {
        try {
            outputView.printSetForbiddenMenu(coachName);
            coachInfo.initForbiddenFood(coachName, inputView.readForbiddenMenu());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            settingForbiddenFood(coachInfo, coachName);
        }
    }

    private void finishRecommendMenu(CoachInfo coachInfo) {
        outputView.printRecommendCategory(menuService.getRecommendedCategoryPerDay());
        for (String coachName : coachInfo.getCoachNames()) {
            outputView.printRecommendedFood(menuService.getRecommendedMenus(coachName), coachName);
        }
    }
}
