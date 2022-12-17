package menu.utils;

public enum ErrorMessage {
    MENU_ERROR("메뉴에 없는 음식입니다."),
    DISLIKE_MENU_ERROR("최소 0개 ~ 2개의 못먹는 메뉴를 올바르게 입력하세요 (, 구분)"),
    COACH_NAME_ERROR("2~5명 코치를 2글자~4글자로 올바르게 입력해주세요. (, 구분)");

    private static final String ERROR_FORMAT = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_FORMAT + message;
    }
}
