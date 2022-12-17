package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


	private static final String ASK_NOT_EAT_MENU_PRINT = "(이)가 못 먹는 메뉴를 입력해 주세요.";
	private static final String INSERT_COACHS_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

	public String askCoachNotPossibleFood(String name) {
		System.out.println(name + ASK_NOT_EAT_MENU_PRINT);
		return Console.readLine();
	}

	public String insertCoachsName(){
		System.out.println(INSERT_COACHS_NAME);
		return Console.readLine();
	}

}
