package menu.controller;

import menu.dto.CoachInputDTO;
import menu.dto.RecommendResultDTO;
import menu.dto.UnavailableMenuDTO;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        startService();
        inputCoachName();
        inputUnavailableMenus();
        recommendMenus();
    }

    private void startService() {
        outputView.printStartMessage();
        menuService.init();
    }

    private void inputCoachName() {
        try {
            CoachInputDTO coachInputDTO = inputView.inputCoachName();
            menuService.createCoaches(coachInputDTO);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            inputCoachName();
        }
    }

    private void inputUnavailableMenus() {
        List<String> allCoachNames = menuService.findAllCoachNames();
        for (String coachName : allCoachNames) {
            inputUnavailableMenu(coachName);
        }
    }

    private void inputUnavailableMenu(String coachName) {
        try {
            UnavailableMenuDTO unavailableMenuDTO = inputView.inputUnavailableMenu(coachName);
            menuService.addUnavailableMenus(coachName, unavailableMenuDTO);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            inputUnavailableMenu(coachName);
        }
    }

    private void recommendMenus() {
        RecommendResultDTO recommendResultDTO = menuService.recommend();
        outputView.printResult(recommendResultDTO);
    }
}
