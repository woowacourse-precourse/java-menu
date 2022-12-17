package menu.message;

public enum InputGuideMessage {
    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    COACH_NAME_INPUT_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INEDIBLE_FOODS_INPUT_MESSAGE("(이)가 못 먹는 메뉴를 입력해 주세요.");
    String message;

    InputGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
