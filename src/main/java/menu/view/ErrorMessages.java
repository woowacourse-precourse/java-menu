package menu.view;

public enum ErrorMessages {
    NAME("[ERROR] 이름은 2글자에서 4글자 사이 이어야 합니다."),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
