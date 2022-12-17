package menu.controller;

public class MainController {
    private static class InstanceHolder {
        private static final MainController INSTANCE = new MainController();
    }

    private MainController(){}

    public static MainController getInstance() {
        return MainController.InstanceHolder.INSTANCE;
    }
}
