package menu;

public enum ExceptionMessage {
    INVALID_COACH_NAME_LEN("코치의 이름은 최소 2글자, 최대 4글자입니다."),
    INVALID_COACH_SIZE("코치는 최소 2명, 최대 5명까지 식사를 함께 해야 합니다."),
    INVALID_NOT_EAT_SIZE("못먹는 메뉴는 2개를 넘을 수 없습니다.")
    ;

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
