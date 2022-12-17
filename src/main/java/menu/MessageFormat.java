package menu;

public enum MessageFormat {
    START_COMMENT("점심 메뉴 추천을 시작합니다"),
    COUCH_NAME_REQUEST_COMMENT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    CANNOT_EAT_MENU_COMMENT_FORMAT("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT_HEADER_COMMENT("메뉴 추천 결과입니다."),
    RESULT_DATA_FORMAT("[ %s ]"),
    INPUT_PARSER(","),
    DATA_PARSER(" | "),
    ERROR_MESSAGE_FORMAT("[ERROR] %s"),
    RESULT_END_COMMENT("추천을 완료했습니다");

    private final String message;

    MessageFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
