package menu.view;

public enum Message {
	SERVICE_START("점심 메뉴 추천을 시작합니다."),
	INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public static void printMessage(Message message) {
		System.out.println(message.message);
	}
}
