package menu.utils.constants;

public enum IOComments {

    START_RECOMMEND("점심 메뉴 추천을 시작합니다.\n"),
    INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_UNEATABLE_FOOD("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT_RECOMMEND("메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
            + "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]"),
    RESULT_START_BRACKET("[ "),
    RESULT_END_BRACKET(" ]"),
    RESULT_DELIMITER(" | "),
    ;

    private final String comments;

    IOComments(final String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }
}
