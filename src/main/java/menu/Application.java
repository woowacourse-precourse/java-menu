package menu;

import menu.client.MenuClient;
import menu.di.MenuUseCaseImpl;

public class Application {

    public static void main(String[] args) {
        MenuClient menuClient = new MenuClient(new MenuUseCaseImpl());
        menuClient.run();
    }
}
