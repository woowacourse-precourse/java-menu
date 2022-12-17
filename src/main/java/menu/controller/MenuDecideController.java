package menu.controller;

import menu.domain.Coaches;
import menu.domain.MenuDecideService;
import menu.view.Input;
import menu.view.Output;

public class MenuDecideController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final MenuDecideService service = new MenuDecideService();

    public void run() {
        output.printStart();
        output.askCoachName();
        makeCoaches();
    }

    private Coaches makeCoaches() {
        try {
            return service.makeCoaches(input.readCoachNames());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return makeCoaches();
        }
    }
}
