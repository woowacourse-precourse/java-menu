package menu.controller.system;

import menu.controller.*;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private static final Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        controllers.put(ControllerName.SETUP, new SetupController());
        controllers.put(ControllerName.SAVING_COACH, new SavingCoachController());
        controllers.put(ControllerName.SAVING_BANNED_MENU, new SavingBannedMenuController());
        controllers.put(ControllerName.SAVING_BANNED_MENU_PER_COACH, new SavingBannedMenuPerCoachController());
        controllers.put(ControllerName.RECOMMENDING, new RecommendingController());
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
