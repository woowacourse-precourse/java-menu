package menu;

import menu.controller.MenuController;

public class Application {

	private static final MenuController menuController = MenuController.getInstance();

	public static void main(String[] args) {
		menuController.runApplication();
	}
}
