package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;

public class InputController {

	public Coaches getCoachName() {
		try {
			return new Coaches(InputView.readCoachName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCoachName();
		}
	}

	public void addAvoidMenu(Coach coach) {
		try {
			String name = coach.getName();
			coach.addAvoidMenu(InputView.readAvoidMenu(name));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			addAvoidMenu(coach);
		}
	}
}
