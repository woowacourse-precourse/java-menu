package menu.utils;

public enum OutputMessage {
    INIT_PROGRAM("점심 메뉴 추천을 시작합니다."),
    INPUT_COUCH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_COUCH_CANNOT_EAT("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMEND_RESULT("메뉴 추천 결과입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
