package menu.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주셔야 합니다."),
    NOT_INPUT_NAMES_BETWEEN_2AND5("이름은 2명 이상, 5명 이하로 작성해 주어야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
