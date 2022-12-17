package menu.util;

public enum ErrorMessage {

    COACH_SIZE_OVER_ERROR_MESSAGE("[ERROR] : 코치들의 수가 범위에 벗어납니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
