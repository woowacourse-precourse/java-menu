package menu.util;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    INVALID_COACH_NUMBER("코치는 최소 2명, 최대 5명이어야 합니다."),
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다."),
    NO_SUCH_MENU("존재하지 않는 메뉴입니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
