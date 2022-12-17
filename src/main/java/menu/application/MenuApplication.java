package menu.application;

import menu.domain.Coach;
import menu.handler.InputHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuApplication {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public MenuApplication() {
        this.inputHandler = new InputHandler(new InputView());
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStart();
        Coach coach = inputHandler.readCoachName();
        inputHandler.readCoachCanNotEat(coach);
    }
}
