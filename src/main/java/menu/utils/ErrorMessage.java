package menu.utils;

public enum ErrorMessage {
    COUCH_NAME_OUT_OF_RANGE("코치의 이름은 최소 2글자, 최대 4글자입니다."),
    COUCH_NAME_DUPLICATE("코치의 이름은 중복될 수 없습니다."),
    COUCH_GROUP_OUT_OF_RANGE("코치는 최소 2명, 최대 5명까지만 식사를 함께 합니다."),
    ;

    private final String message;
    private static final String PREFIX = "[ERROR]";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(" ", PREFIX, message);
    }
}
