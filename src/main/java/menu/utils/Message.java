package menu.utils;

public enum Message {
    START("점심 메뉴 추천을 시작합니다.\n"),
    COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    DISLIKE_MENU("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    FINISH("추천을 완료했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
