package menu.view;

public enum Messages {
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_INEDIBLE_FOOD("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    COMPLETE_RECOMMEND("추천을 완료했습니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
