package menu;

import menu.controller.MenuSelection;
import menu.domain.MenuSelector;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuSelection menuSelection = new MenuSelection(new MenuSelector());
        menuSelection.run();
    }
}
