package menu.view;

public enum ErrorMessage {
    COACH_MIN("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    COACH_MAX("[ERROR] 코치는 최대 5명 이하 입력해야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
