package menu.message;

public enum OutputMsg {
    OUTPUT_MSG_SERVICE_START("점심 메뉴 추천을 시작합니다."),
    OUTPUT_MSG_SERVICE_END_PREFIX("\n" +
            "메뉴 추천 결과입니다.\n" +
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
            "[ 카테고리 | "),
    OPEN_BRAKET("[ "),
    MIDDLE_BRAKET(" | "),
    CLOSE_BRAKET(" ]"),
    OUTPUT_MSG_SERVICE_END_POSTFIX("\n추천을 완료했습니다.");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
