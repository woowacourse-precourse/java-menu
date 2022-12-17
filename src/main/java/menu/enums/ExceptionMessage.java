package menu.enums;

public enum ExceptionMessage {
    IS_NOT_VALID_COACH_NAME("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다. 다시 입력해주세요"),
    IS_NOT_VALID_COACH_COUNT("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하가 되도록 입력해야 합니다. 다시 입력해주세요"),
    IS_NOT_VALID_MENU_LIST("[ERROR] 메뉴 목록은 최소 0개, 최대 2개 입력할 수 있습니다. 다시 입력해주세요.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
