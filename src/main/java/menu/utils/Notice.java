package menu.utils;

public enum Notice {
    START("점심 메뉴 추천을 시작합니다."),
    ENTER_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    ENTER_MENU_INFO("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT("메뉴 추천 결과입니다."),
    WEEK("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    END("추천을 완료했습니다.")
    ;

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    private String getMessage() {
        return message;
    }

    public static String of(Notice notice) {
        return notice.getMessage();
    }

    public static String of(String coachName) {
        return coachName + ENTER_MENU_INFO.getMessage();
    }
}
