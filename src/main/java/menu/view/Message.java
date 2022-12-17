package menu.view;

public enum Message {
	SERVICE_START("점심 메뉴 추천을 시작합니다."),
	INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
	INPUT_NOT_EAT_FOOD("(이)가 못 먹는 메뉴를 입력해 주세요.");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public static void printMessage(Message message) {
		System.out.println(message.message);
	}

	public static void printNotEatFoodMessage(String name) {
		System.out.println(name + INPUT_NOT_EAT_FOOD);
	}

}
