package menu;

import menu.cotroller.MenuController;
import menu.domain.game.MenuGame;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		MenuGame menuGame = new MenuGame();
		MenuController menuController = new MenuController(inputView, outputView, menuGame);
		menuController.startGame();

	}
}
