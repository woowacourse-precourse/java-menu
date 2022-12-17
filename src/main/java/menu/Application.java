package menu;

import menu.config.MenuApplicationFactory;
import menu.domain.MenuApplication;

public class Application {
    public static void main(String[] args) {
        MenuApplicationFactory menuApplicationFactory = new MenuApplicationFactory();
        MenuApplication menuApplication = menuApplicationFactory.generateApp();
        menuApplication.run();
    }
}
