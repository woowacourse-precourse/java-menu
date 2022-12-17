package menu.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해야 합니다."),
    NOT_INPUT_NAMES_LESS_THAN_TWO("코치는 최소 2명 이상 입력해야 합니다."),
    NOT_INPUT_NAMES_OVER_FIVE("코치는 최대 5명 이하 입력해야 합니다."),
    NAME_LESS_THAN_TWO("코치 이름은 최소 2자 이상으로 입력해야 합니다."),
    NAME_MORE_THAN_FOUR("코치 이름은 최대 4자 이하 입력해야 합니다."),
    NOT_EXIST_MENU("존재하지 않는 메뉴입니다."),
    MENU_MORE_THAN_TWO("메뉴는 최대 2개 이하 입력해야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
