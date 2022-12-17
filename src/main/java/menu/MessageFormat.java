package menu;

public enum MessageFormat {
    START_COMMENT("점심 메뉴 추천을 시작합니다"),
    RESULT_HEADER_COMMENT("메뉴 추천 결과입니다."),
    RESULT_DATA_FORMAT("[ %s ]"),
    DATA_PARSER(" | "),
    RESULT_END_COMMENT("추천을 완료했습니다");

    private final String message;

    MessageFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
