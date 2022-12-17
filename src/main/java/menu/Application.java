package menu;

import menu.controller.ControllerFactory;
import menu.controller.ControllerType;

public class Application {
    public static void main(String[] args) {
        ControllerFactory.get(ControllerType.MAIN).execute();
    }
}
