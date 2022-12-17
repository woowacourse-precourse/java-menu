package menu.utils;

public enum Errors {
    ERROR_TAG("[ERROR] "),
    INPUT_KOREAN_COACH_NAME("코치 이름은 한글만 입력할 수 있습니다."),
    NOT_RIGHT_NUMBER_OF_NAME_LENGTH("코치 이름은 2글자에서 4글자 사이어야 합니다."),
    NOT_RIGHT_COACH_SIZE("코치는 2명에서 5명 사이로 입력해주세요."),
    NOT_EXIST_CATEGORY("존재하지 않는 카테고리 입니다."),
    ENTER_KOREAN_MENU("메뉴 이름은 한글만 입력할 수 있습니다."),
    NOT_RIGHT_NUMBER_OF_MENU("못 먹는 음식은 0 ~ 2개만 가능합니다.");

    private final String message;

    Errors(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void printLog(final String log) {
        System.out.println(ERROR_TAG + log);
    }
}
