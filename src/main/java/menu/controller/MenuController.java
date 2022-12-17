package menu.controller;

import menu.service.MenuManager;
import menu.view.Input;
import menu.view.Output;

import java.util.List;

public class MenuController {

    private final MenuManager menuManager = new MenuManager();

    private final Input input = new Input();

    private final Output output = new Output();

    public void run() {
        printStartMessage();
        saveCoachNames();
        saveHatingMenus();
        printResult();

    }

    private void printResult() {
        menuManager.activateRecommendation();
    }

    private void saveHatingMenus() {
        List<String> coachNames = menuManager.findAllCoachNames();
        for (String coachName : coachNames) {
            List<String> hatingMenus = getHatingMenus(coachName);
            menuManager.saveHatingMenus(hatingMenus, coachName);
        }
    }

    private List<String> getHatingMenus(String coachName) {
        output.printHatingMenusMessage(coachName);
        try {
            return input.readHatingMenus();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e);
            return getHatingMenus(coachName);
        }
    }

    private void saveCoachNames() {
        List<String> coachNames = getCoachNames();
        menuManager.saveCoach(coachNames);

    }

    private List<String> getCoachNames() {
        output.printCoachNamesMessage();
        try {
            return input.readCoachNames();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e);
            return getCoachNames();
        }
    }

    private void printStartMessage() {
        output.printStartMessage();
    }
}
