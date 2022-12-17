package menu;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Service service = new Service();
        service.start();
        service.getCoach();
        service.getHateMenus();
    }
}
