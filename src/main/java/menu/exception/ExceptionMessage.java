package menu.exception;public enum ExceptionMessage {    ERROR_MESSAGE_PREFIX("[ERROR] "),    NOT_FOUND_COACH_NAME("등록되지 않은 코치님 이름입니다.");    private final String message;    ExceptionMessage(String message) {        this.message = message;    }    public String getErrorMessage() {        return ERROR_MESSAGE_PREFIX.message + this.message;    }}