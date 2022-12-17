package menu.controller;

import menu.dto.CoachNamesDto;
import menu.dto.CoachesDto;
import menu.dto.RecommendationResultDto;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        outputView.init();
        CoachNamesDto coachNamesDto = registerCoaches();
        setCannotEat(coachNamesDto);
        recommendMenus();
    }

    private CoachNamesDto registerCoaches() {
        try {
            return inputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            outputView.printErr(e.getMessage());
            return registerCoaches();
        }
    }

    private void setCannotEat(CoachNamesDto coachNamesDto) {
        try {
            CoachesDto coachesDto = inputView.readNoEats(coachNamesDto);
            menuService.registerCoaches(coachesDto);
        } catch (IllegalArgumentException e) {
            outputView.printErr(e.getMessage());
            setCannotEat(coachNamesDto);
        }
    }

    private void recommendMenus() {
        RecommendationResultDto recommendationResultDto = menuService.recommendMenus();
        outputView.printRecommendationResult(recommendationResultDto);
    }
}
