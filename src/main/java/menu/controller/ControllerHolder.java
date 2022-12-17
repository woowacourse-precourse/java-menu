package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;
import menu.vo.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private static final Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        controllers.put(ControllerName.SETUP, new SetupController());
        controllers.put(ControllerName.MAIN, new MainController(new InputView(), new OutputView()));
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
