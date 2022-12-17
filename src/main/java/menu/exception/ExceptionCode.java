package menu.exception;

public enum ExceptionCode {
    OUT_OF_RANGE_COACH_COUNT("[ERROR] 코치는 최소 2명, 최대 5명까지 입력할 수 있습니다."),
    OUT_OF_RANGE_NO_MENU_COUNT( "[ERROR] 먹지 못하는 메뉴는 0개부터 2개까지 입력할 수 있습니다."),
    NOT_CORRECT_COACH_NAME("[ERROR] 코치의 이름은 최소 최소 2글자, 최대 4글자입니다."),
    NOT_SEPERATED_BY_COMMA("[ERROR] 콤마(,)로 구분되어야 합니다."),
    IS_EMPTY("[ERROR] 공백은 허용하지 않습니다."),
    IS_BLANK("[ERROR] 빈 값은 허용하지 않습니다.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
