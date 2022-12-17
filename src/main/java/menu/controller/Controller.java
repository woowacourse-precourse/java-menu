package menu.controller;

import java.util.List;

import menu.model.Category;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.MenuList;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

	private Coaches coaches;
	private Menu menu;
	private MenuList menusCantEat;
	private InputView inputView;
	private Category category;

	public Controller() {
		this.inputView = new InputView();
		this.menusCantEat = new MenuList();
	}

	public void logic() {
		OutputView.printStartMessage();
		coaches = setCoachesName();
		menusCantEat = setMenusCantEat();
		OutputView.printResult();
	}

	private Coaches setCoachesName() {
		OutputView.printCoachNameInputMessage();
		List<String> names = inputView.inputCoaches();
		return new Coaches(names);
	}

	private MenuList setMenusCantEat() {
		for (int i = 0; i < coaches.getNames().size(); i++) {
			OutputView.printMenuInputMessage(coaches.getNames().get(i));
			List<String> menuNames = inputView.inputMenuCantEat();
			menusCantEat.getMenusCantEat().add(new Menu(menuNames));
		}
		return menusCantEat;
	}
}
