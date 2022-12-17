package menu.view.message;

public enum Message {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME_GUIDE("코치의 이름을 입력해 주세요. (, 로 구분)\n"),
    HATE_MENU_GUIDE("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... factor) {
        return String.format(message, factor);
    }
}
