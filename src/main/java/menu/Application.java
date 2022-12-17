package menu;

import menu.controller.MenuSuggestionController;

public class Application {
    public static void main(String[] args) {
        MenuSuggestionController menuSuggestionController = new MenuSuggestionController();
        menuSuggestionController.startSuggestion();
    }
}
