package menu.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private static final Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        controllers.put(ControllerName.SETUP, new SetupController());
        controllers.put(ControllerName.COACH_INFO, new CoachInfoController());
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
