package menu.view;

public enum Messages {

    LUNCH_SUGGEST_START("점심 메뉴 추천을 시작합니다.\n"),
    INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    COACH_UNEATABLE("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
    LUNCH_SUGGEST_RESULT("\n메뉴 추천 결과입니다."),
    DAYS("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    SUGGESTION_FINISHED("추천을 완료했습니다.");

    private final String message;

    Messages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
