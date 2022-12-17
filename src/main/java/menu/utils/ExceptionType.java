package menu.utils;

public enum ExceptionType {
    IS_LOWER_THAN_SIZE("입력된 값이 정해진 크기보다 작습니다."),
    IS_BIGGER_THAN_SIZE("입력된 값이 정해진 크기보다 큽니다."),
    IS_NOT_KOREAN("입력된 값이 한글가 아닙니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionType(String message) {
        this.message = ERROR_MESSAGE + message;
    }


    @Override
    public String toString() {
        return message;
    }
}
