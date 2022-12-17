package menu.controller;

import menu.view.OutputView;

public class ErrorCheckController implements Controllable {

    private final Controllable targetController;
    private OutputView outputView = new OutputView();

    public ErrorCheckController(Controllable mainController) {
        this.targetController = mainController;
    }

    @Override
    public void execute() {
        try {
            targetController.execute();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            execute();
        }
    }
}
