package menu.message;

public enum ErrorMsg {
    ERROR_MSG_DUPLICATED_ELEMENT_IN_LIST("중복되지 않는 값으로 입력해야 합니다."),
    ERROR_MSG_SIZE_OF_COACHES_NAME_IS_UNDER_TWO("코치는 최소 2명 이상으로 입력해야 합니다."),
    ERROR_MSG_SIZE_OF_COACHES_NAME_IS_OVER_FIVE("코치는 최대 5명 이하로 입력해야 합니다."),
    ERROR_MSG_SIZE_OF_HATE_FOODS_IS_OVER_TWO("못 먹는 메뉴는 최대 2개 이하로 입력해야 합니다."),
    ERROR_MSG_FOOD_IS_NOT_EXIST_IN_MENU("존재하는 메뉴만 입력해야 합니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
