package menu.view;

public enum Message {

    ERROR("[ERROR] %s"),
    SERVICE_START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
    IMPOSSIBLE_TO_EAT("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
