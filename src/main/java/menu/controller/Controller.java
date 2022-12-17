package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.WeeklyMenu;
import menu.service.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
	public void run() {
		OutputView.printStartMessage();
		Coaches coaches = InputController.getCoachName();
		coaches.getCoaches().forEach(InputController::avoidMenu);
		WeeklyMenu weeklyMenu = new WeeklyMenu();
		Menu menu = new Menu(coaches);
		OutputView.printResult(weeklyMenu, menu);
	}
}
