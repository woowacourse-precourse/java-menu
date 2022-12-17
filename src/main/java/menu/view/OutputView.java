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
		System.out.printf("\n" + name + MENU_INPUT_MSG);
	}

	public static void printResult() {
		System.out.println("메뉴 추천 결과입니다.\n"
			+ "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
			+ "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
	}

	public static void printEndMessage() {
		System.out.println(END_MSG);
	}
}
