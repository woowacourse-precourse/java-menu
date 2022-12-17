package menu.util.message;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    COACH_NAME_OUT_OF_SCOPE("코치의 이름은 최소 2글자, 최대 4글자입니다."),
    COACH_NUMBER_OUT_OF_SCOPE("코치는 최소 2명, 최대 5명까지 식사를 함께 합니다."),
    DUPLICATED_COACH_NAME("코치의 이름이 중복됩니다."),
    CANNOT_EAT_MENU_OUT_OF_SCOPE("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX.message + this.message;
    }
}