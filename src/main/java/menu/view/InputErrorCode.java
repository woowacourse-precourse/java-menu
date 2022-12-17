package menu.view;

public enum InputErrorCode {
    TOO_LOW_COACH_NUMBER("코치는 최소 2명 이상 입력해야 합니다."),
    TOO_MUCH_COACH_NUMBER("코치는 최대 5명 입력해야 합니다."),
    INVALID_COACH_NAME("코치 이름은 2~4글자이어야 합니다."),
    TOO_MUCH_BANNED_MENU("메뉴는 최대 2개까지 입력 가능합니다."),
    MENU_NOT_EXIST("존재하지 않는 메뉴가 있습니다.");

    private final String ERROR_DESCRIPTION;

    InputErrorCode(String errorDescription) {
        this.ERROR_DESCRIPTION = errorDescription;
    }

    @Override
    public String toString() {
        return "[ERROR] " + ERROR_DESCRIPTION;
    }
}
