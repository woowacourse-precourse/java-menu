package menu.view;

public enum ErrorMessage {
    IS_NOT_HANGUL("[ERROR] 한글을 입력해주세요."),
    COACH_SIZE_IS_NOT_IN_RANGE("[ERROR] 코치는 최소 2명 이상 5명 이하로 입력해야 합니다."),
    NAME_SIZE_IS_NOT_IN_RANGE("[ERROR] 코치의 이름는 최소 2글자 이상 4글자 이하로 입력해야 합니다."),
    IS_NOT_CATEGORY("[ERROR] 카테고리에 포함되어 있는 음식의 이름을 입력해야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
