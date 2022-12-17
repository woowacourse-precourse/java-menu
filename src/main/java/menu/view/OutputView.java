package menu.view;

import static menu.Constant.*;

public class OutputView {

	public static void printStartMessage() {
		System.out.println(START_MSG);
	}

	public static void printCoachNameInputMessage() {
		System.out.println(COACH_INPUT_MSG);
	}

	public static void printMenuInputMessage(String name) {
		System.out.printf(name + MENU_INPUT_MSG);
	}
}
