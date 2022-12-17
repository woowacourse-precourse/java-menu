package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.cotroller.MenuController;
import menu.domain.food.ChinaFood;
import menu.domain.food.JapanFood;
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
