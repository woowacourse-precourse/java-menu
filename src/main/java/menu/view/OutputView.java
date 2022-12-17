package menu.view;

import java.util.stream.Collectors;
import menu.domain.category.Categorys;
import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.domain.game.MenuGame;

public class OutputView {

	public static final String ENTER = System.lineSeparator();
	private static final String RECOMMAND_MENU_PRINT = "점심 메뉴 추천을 시작합니다.";
	private static final String RECOMMAND_MENU_RESULT_PRINT = "메뉴 추천 결과입니다.";
	private static final String RECOMMAND_END_PRINT = "추천을 완료했습니다.";
	private static final String CATEGORY_PRINT = "카테고리 | ";
	private static final String MENU_RESULT_OPEN = "[ ";
	private static final String MENU_RESULT_CLOSE = " ]";
	private static final String MENU_RESULT_MIDDLE = " | ";
	private static final String DAY_PRINT = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

	public void recommandMenu() {
		System.out.println(RECOMMAND_MENU_PRINT);
	}

	public void printResult(MenuGame menuGame) {
		System.out.println(RECOMMAND_MENU_RESULT_PRINT);
		System.out.println(DAY_PRINT);
		printCategory(menuGame.getCategorys());
		printCoachMenu(menuGame.getCoachs());
		System.out.println(RECOMMAND_END_PRINT);
	}

	public void printCategory(Categorys categorys) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(MENU_RESULT_OPEN);
		stringBuffer.append(CATEGORY_PRINT);
		stringBuffer.append(String.join(MENU_RESULT_MIDDLE, categorys.getCategories()));
		stringBuffer.append(MENU_RESULT_CLOSE);
		System.out.println(stringBuffer);
	}

	public void printCoachMenu(Coachs coachs) {
		StringBuffer stringBuffer = new StringBuffer();
		for (Coach coach : coachs.getCoaches()) {
			stringBuffer.append(MENU_RESULT_OPEN);
			stringBuffer.append(coach.getName() + MENU_RESULT_MIDDLE);
			stringBuffer.append(String.join(MENU_RESULT_MIDDLE, coach.getRecommandMenus()));
			stringBuffer.append(MENU_RESULT_CLOSE);
			stringBuffer.append(ENTER);
		}

		System.out.println(stringBuffer);
	}

	public void errorPrint(String error) {
		System.out.println(error);
	}


}
