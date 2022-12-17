package menu.utils;

public enum ErrorMessage {
    MENU_ERROR("메뉴에 없는 음식입니다."),
    DISLIKE_MENU_ERROR("최소 0개 ~ 2개의 못먹는 메뉴를 올바르게 입력하세요 (, 구분)"),
    COACH_MIN_COUNT_ERROR("코치는 최소 2명 이상 입력해야 합니다."),
    COACH_COUNT_ERROR("코치는 최소 2명에서 최대 5명 입력해야 합니다."),
    COACH_NAME_ERROR("코치 이름을 2글자에서 4글자로 올바르게 입력해주세요. (, 구분)");

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
