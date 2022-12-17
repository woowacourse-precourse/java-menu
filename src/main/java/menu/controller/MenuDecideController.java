package menu.controller;

import menu.domain.Coach;
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
        makeCoach();
    }

    private Coach makeCoach() {
        try {
            return service.makeCoach(input.readCoachName());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return makeCoach();
        }
    }
}
