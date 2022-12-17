package menu.system;

import menu.controller.ControllerHolder;
import menu.controller.ControllerName;

public class MenuApplication {

    public void run() {
        doSetup();
        ControllerHolder.get(ControllerName.COACH_INFO).process();
    }

    private static void doSetup() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
