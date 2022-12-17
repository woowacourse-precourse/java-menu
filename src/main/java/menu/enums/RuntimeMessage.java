package menu.enums;

public enum RuntimeMessage {
    PROGRAM_START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    COACH_NAME_INPUT_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    MENU_RECOMMENDATION_RESULT_MESSAGE("메뉴 추천 결과입니다."),
    DAY_OF_WEEK_LIST_MESSAGE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    PROGRAM_END_MESSAGE("추천을 완료했습니다.");

    private String message;

    RuntimeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
