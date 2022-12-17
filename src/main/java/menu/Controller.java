package menu;

import menu.service.Service;

public class Controller {
    private final Service service = new Service();
    public void run() {
        setMenus();
    }

    private void setMenus() {
        service.setMenus();
    }
}
