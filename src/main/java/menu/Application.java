package menu;

import menu.controller.MenuSuggestController;

public class Application {
    public static void main(String[] args) {
        MenuSuggestController menuSuggestController = new MenuSuggestController();
        menuSuggestController.run();
    }
}
