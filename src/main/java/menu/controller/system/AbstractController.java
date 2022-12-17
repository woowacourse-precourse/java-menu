package menu.controller.system;

import menu.outputview.ErrorHandlingOutputView;

public abstract class AbstractController implements Controller {
    @Override
    public void process() {
        try {
            doProcess();
        } catch (IllegalArgumentException e) {
            ErrorHandlingOutputView.printErrorMessage(e.getMessage());
            process();
        }
    }

    public abstract void doProcess();
}
