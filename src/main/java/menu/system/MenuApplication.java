package menu.system;

import menu.controller.ControllerHolder;
import menu.controller.ControllerName;

public class MenuApplication {

    public void run() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
