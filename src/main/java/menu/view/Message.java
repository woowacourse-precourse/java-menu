package menu.view;

public enum Message {
    START("점심 메뉴 추천을 시작합니다."),
    REQUEST_MEMBER_NAME("코치 이름을 입력해 주세요. (, 로 구분)"),
    REQUEST_CANT_EAT("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESPONSE_RECOMMEND("메뉴 추천 결과입니다."),
    EXIT("\n추천을 완료했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
