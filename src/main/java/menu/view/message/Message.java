package menu.view.message;

public enum Message {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME_GUIDE("코치의 이름을 입력해 주세요. (, 로 구분)\n"),
    HATE_MENU_GUIDE("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
    RESULT_GUIDE("메뉴 추천 결과입니다."),
    RECOMMENDATION_FINISHING("추천을 완료했습니다."),
    PRINT_FORM("[ %s ]\n"),
    DELIMITER(" | "),
    FIRST_ROW_TITLE("구분"),
    CATEGORY("카테고리");

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
