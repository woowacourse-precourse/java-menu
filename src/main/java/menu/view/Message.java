package menu.view;

public enum Message {
    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    NAME_REQUEST_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    FOOD_REQUEST_MESSAGE("(이)가 못 먹는 메뉴를 입력해 주세요."),
    MENU_RESULT_MESSAGE("메뉴 추천 결과입니다."),
    SUCCESS_MESSAGE("추천을 완료했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
