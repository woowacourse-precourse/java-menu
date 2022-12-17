package menu.utils;

public enum Constants {
    ERROR_PREFIX("[ERROR] "),

    START_MESSAGE("점심 메뉴 추천을 시작합니다.\n"),
    RESULT_MESSAGE("메뉴 추천 결과입니다.\n"
        + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    END_MESSAGE("추천을 완료했습니다.\n"),


    INPUT_NAME_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)\n"),
    INPUT_REMOVE_LIST_MESSAGE("(이)가 못 먹는 메뉴를 입력해 주세요."),

    MAP_PREFIX("[ "),
    MAP_DELIMITER(" | "),
    MAP_SUFFIX(" ]\n");
    ;


    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getConstants() {
        return message;
    }

}
