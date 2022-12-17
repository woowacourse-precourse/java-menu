package menu.system;

import menu.controller.ControllerHolder;
import menu.controller.ControllerName;

public class MenuApplication {

    public void run() {
        doSetup();
        getCoachInfo();
        doRecommending();
    }

    private static void doRecommending() {
        ControllerHolder.get(ControllerName.RECOMMANDING).process();
    }

    private static void getCoachInfo() {
        ControllerHolder.get(ControllerName.COACH_INFO).process();
    }

    private static void doSetup() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
