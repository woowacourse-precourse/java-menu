package menu.view.constant;

public enum ViewErrorMessage {
    EMPTY("빈 값 입니다."),
    NOT_NUMBER("숫자만 입력해주세요.");

    private final String message;

    ViewErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
