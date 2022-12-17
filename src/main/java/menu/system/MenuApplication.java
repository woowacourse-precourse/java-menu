package menu.system;

import menu.controller.ControllerHolder;
import menu.vo.ControllerName;

public class MenuApplication {
    public void run() {
        doSetup();
        ControllerHolder.get(ControllerName.MAIN).process();
    }

    private static void doSetup() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
