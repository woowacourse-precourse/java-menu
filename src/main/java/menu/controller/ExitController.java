package menu.controller;

import menu.view.Message;
import menu.view.OutputView;

public class ExitController implements Controllable{
    private final OutputView outputView;
    public ExitController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void execute() {
        outputView.printMessage(Message.EXIT);
    }
}
