package menu.enums;

public enum ErrorMessage {
    NAME_OUT_OF_SIZE("[ERROR] 코치의 이름은 2글자에서 4글자를 입력해야 합니다."),
    EAT_TOGETHER_OUT_OF_RANGE("[ERROR] 코치는 최소 2명, 최대 5명이서 식사를 함께할 수 있습니다."),
    DISLIKE_FOOD_OUT_OF_SIZE("[ERROR] 코치가 못먹는 메뉴의 수는 2개를 넘을 수 없습니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
