package menu.controller.system;

import menu.outputview.ErrorHandlingOutputView;

import java.util.Map;

public abstract class AbstractController implements Controller {
    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            ErrorHandlingOutputView.printErrorMessage(e.getMessage());
            process(model);
        }
    }

    public abstract void doProcess(Map<String, Object> model);
}
