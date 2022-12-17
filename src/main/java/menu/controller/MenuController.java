package menu.controller;

public class MenuController {

    public MenuController() {
        initMenus();
    }

    public void run() {

    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker();
        menuMaker.makeMenus();
    }
}
