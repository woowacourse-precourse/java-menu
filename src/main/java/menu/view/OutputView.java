package menu.view;

public class OutputView {

	private static final String initMsg = "점심 메뉴 추천을 시작합니다.";
	private static final String resultMsg= "메뉴 추천 결과입니다.";
	private static final String endMsg = "추천을 완료했습니다.";

	public static void printInitMsg() {
		System.out.println(initMsg);
	}

	public static void printResult() {
		System.out.println(resultMsg);
		// TODO: result 변환
	}

	public static void printEndMsg() {
		System.out.println(endMsg);
	}
}
