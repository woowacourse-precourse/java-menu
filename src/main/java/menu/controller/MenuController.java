package menu.controller;

import java.util.List;

import menu.model.Coach;
import menu.service.MenuService;

public class MenuController {

	private final MenuService menuService = MenuService.getInstance();

	private static final MenuController instance = new MenuController();

	private MenuController() {
	}

	public static MenuController getInstance() {
		return instance;
	}

	public void runApplication() {
		menuService.startService();
		List<Coach> coachList = menuService.makeCoachList();
		menuService.setNotEatFood(coachList);
		menuService.recommendCategory(coachList);
		menuService.recommendFood(coachList);
		menuService.finishService(coachList);
	}

}
