package menu.system;

import menu.controller.system.ControllerHolder;
import menu.controller.system.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class MenuApplication {

    public void run() {
        Map<String, Object> model = new HashMap<>();
        doSetup(model);
        getCoachInfo(model);
        doRecommending(model);
    }

    private static void doRecommending(Map<String, Object> model) {
        ControllerHolder.get(ControllerName.RECOMMENDING).process(model);
    }

    private static void getCoachInfo(Map<String, Object> model) {
        ControllerHolder.get(ControllerName.SAVING_COACH).process(model);
        ControllerHolder.get(ControllerName.SAVING_BANNED_MENU).process(model);
    }

    private static void doSetup(Map<String, Object> model) {
        ControllerHolder.get(ControllerName.SETUP).process(model);
    }
}
