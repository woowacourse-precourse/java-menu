package menu;

public class Application {

    public static void main(String[] args) {
        try {
            Controller.run();
        } catch (IllegalArgumentException error) {
            System.out.println(OutputView.ERROR_PREFIX + error.getMessage());
        }
    }
}
