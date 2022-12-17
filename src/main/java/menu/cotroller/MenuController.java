package menu.cotroller;

import menu.domain.game.MenuGame;
import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

	InputView inputView;
	OutputView outputView;
	MenuGame menuGame;

	public MenuController(InputView inputView, OutputView outputView, MenuGame menuGame) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.menuGame = menuGame;
	}

	public void startGame() {
		outputView.recommandMenu();
		play();
		endGame(menuGame);
	}

	public void play() {
		Coachs coachs = insertCoachesName();
		askNotPossibleFood(coachs);
		menuRecommand();
	}

	public Coachs insertCoachesName() {
		while (true) {
			try {
				String names = inputView.insertCoachsName();
				return menuGame.insertCoaches(names);
			} catch (IllegalArgumentException e) {
				outputView.errorPrint(e.getMessage());
				insertCoachesName();
			}
		}
	}

	public void askNotPossibleFood(Coachs coachs) {
		for (Coach coach : coachs.getCoaches()) {
			String foods = inputView.askCoachNotPossibleFood(coach.getName());
			menuGame.insertNotPossibleMenu(coach, foods);
		}
	}
	public void menuRecommand(){
		menuGame.menuRecommand();
	}

	public void endGame(MenuGame menuGame){
		outputView.printResult(menuGame);
	}


}
