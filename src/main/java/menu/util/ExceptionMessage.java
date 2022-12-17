package menu.util;

public enum ExceptionMessage {

    INVALID_SMALL_COACH_NUMBER("코치는 최소 2명 이상 입력해야 합니다."),
    INVALID_BIG_COACH_NUMBER("코치는 최대 5명까지 입력할 수 있습니다."),
    INVALID_SHORT_COACH_NAME_LENGTH("코치의 이름은 최소 2글자여야 합니다."),
    INVALID_LONG_COACH_NAME_LENGTH("코치의 이름은 최대 4글자여야 합니다."),
    NO_SUCH_MENU("존재하지 않는 메뉴입니다."),
    NO_SUCH_CATEGORY("존재하지 않는 카테고리입니다."),
    INVALID_MENU_NOT_TO_EAT_SIZE("못 먹는 메뉴는 2개까지 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
