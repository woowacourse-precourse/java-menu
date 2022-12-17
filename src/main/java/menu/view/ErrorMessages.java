package menu.view;

public enum ErrorMessages {
    COACH_NAME("[ERROR] 이름은 2글자에서 4글자 사이 이어야 합니다."),
    COACH_NUMBER_MIN("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    COACH_NUMBER_MAX("[ERROR] 코치는 최대 5명 입니다."),
    NUMBER_OF_INEDIBLE("[ERROR] 못먹는 음식은 0개에서 2개까지 입력 가능합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
