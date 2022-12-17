package menu.controller;

import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

    public MenuController() {
        initMenus();
    }

    public void run() {
        OutputView.printServiceStartMessage();
        addCoaches();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker();
        menuMaker.makeMenus();
    }

    private void addCoaches() {
        try {
            List<String> coachesName = InputView.inputCoachesName();
            CoachRepository.addCoaches(coachesName);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            CoachRepository.clearCoaches();
            addCoaches();
        }
    }
}
