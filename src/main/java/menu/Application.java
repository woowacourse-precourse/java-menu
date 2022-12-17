package menu;

public class Application {
    public static void main(String[] args) {
        ServiceController serviceController = new ServiceController();
        try {
            serviceController.runService();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}