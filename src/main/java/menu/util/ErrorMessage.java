package menu.util;

public enum ErrorMessage {

    NAME_SIZE_OVER_ERROR_MESSAGE("[ERROR] : 이름은 최소 2글자에서 최대 5글자 이하로 입력해야 합니다."),
    COACH_SIZE_OVER_ERROR_MESSAGE("[ERROR] : 코치는 최소 2명 이상 최대 5명 이하로 입력해야 합니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
