package menu.view.message;

public enum Message {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME_GUIDE("코치의 이름을 입력해 주세요. (, 로 구분)\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
