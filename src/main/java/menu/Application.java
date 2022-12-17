package menu;

public class Application {

    private static final int INIT = 0;
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.initGame();
        controller.calculateMenu(INIT);
    }
}
