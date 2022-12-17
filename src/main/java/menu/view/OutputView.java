package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.WeeklyMenu;
import menu.service.Menu;

public class OutputView {

	private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
	private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
	private static final String DAY_OF_WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

	public static void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	public static void printResult(WeeklyMenu weeklyMenu, Menu menu) {
		System.out.println(RESULT_MESSAGE);
		System.out.println(DAY_OF_WEEK_MESSAGE);
		System.out.printf("[ 카테고리 %s]%n", weeklyMenu.getWeeklyMenuResult());
		System.out.println(menu.getWeeklyMenu());
		System.out.println("추천을 완료했습니다.\n");

	}

}
