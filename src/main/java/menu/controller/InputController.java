package menu.controller;

import java.util.ArrayList;
import java.util.List;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.ErrorMessage;
import menu.view.InputView;

public class InputController {

	public static Coaches getCoachName() {
		try {
			return new Coaches(InputView.readCoachName());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCoachName();
		}
	}

	public static void avoidMenu(Coach coach) {
		try {
			String[] avoidMenus = InputView.readAvoidMenu(coach.getName()).split(",");
			if (avoidMenus.length > 2) {
				throw new IllegalArgumentException(ErrorMessage.AVOID_MENU.getMessage());
			}
			coach.addAvoidMenu(List.of(avoidMenus));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			avoidMenu(coach);
		}
	}
}
