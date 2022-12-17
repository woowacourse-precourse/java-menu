package menu;

import menu.controller.MenuController;
import menu.model.MenuSuggester;

public class Application {
    public static void main(String[] args) {
        MenuSuggester menuSuggester = new MenuSuggester();
        MenuController menuController = new MenuController(menuSuggester);
        menuController.run();
    }
}
