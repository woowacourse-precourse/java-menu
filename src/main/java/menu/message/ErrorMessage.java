package menu.message;

public enum ErrorMessage {
    prefix("[ERROR] "),
    coachNameInputError(prefix.message + "코치는 최소 2명 이상, 최대 5명 이하로 공백없이 입력해야 합니다."),
    inedibleFoodInputError(prefix.message + "싫어하는 음식은 최대 2개 이하로 공백없이 입력해야 합니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
