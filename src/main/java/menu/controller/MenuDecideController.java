package menu.controller;

import menu.domain.MenueDecideService;
import menu.view.Input;
import menu.view.Output;

public class MenuDecideController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final MenueDecideService service = new MenueDecideService();

    public void run() {
        output.printStart();
        output.askCoachName();
        String coachName = input.readCoachName();
    }
}
