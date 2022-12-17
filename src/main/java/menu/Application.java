package menu;

import menu.Controller.Service;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();
        service.generateCoachs();
        service.setInedible();
        service.makeRecommendations();
        service.endService();
    }
}
