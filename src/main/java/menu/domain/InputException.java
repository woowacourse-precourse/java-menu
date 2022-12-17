package menu.domain;

public enum InputException {
    DUPLICATE_COACH_NAME("중복된 코치 이름입니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
