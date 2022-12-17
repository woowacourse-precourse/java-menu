package menu.view;

public class OutputView {

	private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
	private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
	private static final String DAY_OF_WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

	public void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	public void printResult() {
		System.out.println(RESULT_MESSAGE);
		System.out.println(DAY_OF_WEEK_MESSAGE);

	}

}
