package menu.Controller;

import menu.Service.InitializationService;

public class MenuController {
    InitializationService initializationService;

    public MenuController() {
        initializationService = new InitializationService();
    }

    public void run() {
        initializationService.initializeCategory();
    }
}
