package menu;

public class Application {

    public static void main(String[] args) {
        Service service = new Service();
        service.start();
        service.getCoach();
        service.getHateMenus();
        service.initDays();
        service.recommendMenu();
        service.showResult();
    }
}
