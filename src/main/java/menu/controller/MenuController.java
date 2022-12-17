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

    }

    private void saveCoachNames() {
        List<String> coachNames = getCoachNames();

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
