package menu.constans;

public enum Message {
    START("점심 메뉴 추천을 시작합니다."),
    REQUEST_COUCH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    REQUEST_FOODS_CANT_EAT("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    COMPLETION("추천을 완료했습니다."),
    RESULT_TEMPLATE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
