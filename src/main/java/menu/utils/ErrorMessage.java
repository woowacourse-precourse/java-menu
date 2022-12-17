package menu.utils;

public enum ErrorMessage {
    MIN_COACH_NUM_ERROR("코치는 최소 %d명 이상 입력해야 합니다."),
    MAX_COACH_NUM_ERROR("코치는 최대 %d명 이하로 입력해야 합니다."),
    MIN_COACH_NAME_LENGTH_ERROR("코치의 이름은 %d자 이상으로 입력해야 합니다."),
    MAX_COACH_NAME_LENGTH_ERROR("코치의 이름은 %d자 이하로 입력해야 합니다."),
    MAX_HATE_MENU_NUM_ERROR("먹지 못하는 음식의 수는 %d 이하로 입력해야 합니다"),
    SEPARATOR_ERROR("구분자로 ,을 사용해야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage(int num) {
        return "[ERROR] " + String.format(message, num);
    }

    public String getErrorMessage() {
        return "[ERROR] " + message;
    }
}
