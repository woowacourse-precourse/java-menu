package menu.controller;

import menu.view.ErrorMessageView;

public abstract class AbstractController implements Controller {
    @Override
    public void process() {
        try {
            doProcess();
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printErrorMessage(e.getMessage());
            process();
        }
    }

    abstract void doProcess();
}
