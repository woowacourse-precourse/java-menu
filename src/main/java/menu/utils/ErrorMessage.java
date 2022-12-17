package menu.utils;

public enum ErrorMessage {

	LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다."),
	RANGE("코치는 최소 2명 이상 최대 5명 이하만 입력해야 합니다."),
	AVOID_MENU("못 먹는 메뉴는  최소 0개, 최대 2개여야 합니다.")
	;

	private static final String ERROR = "[ERROR] ";

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR + message;
	}
}
