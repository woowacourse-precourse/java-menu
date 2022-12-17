package menu.controller;

import menu.view.Message;
import menu.view.OutputView;

public class MainController implements Controllable {
    private final OutputView outputView;

    public MainController(OutputView outputView) {
        this.outputView = outputView;
    }


    @Override
    public void execute() {
        outputView.printMessage(Message.START);
        ControllerFactory.get(ControllerType.INPUT_MEMBER).execute();
    }
}
