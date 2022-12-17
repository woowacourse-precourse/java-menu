package menu.util;

public enum ErrorCode {
    NOT_VALID_INPUT("값이 입력되지 않았습니다"),
    NOT_VALID_CATEGORY("해당하는 음식 카테고리가 없습니다."),
    NOT_VALID_COACH_COUNT_MIN("코치는 최소 2명 이상 입력해야 합니다."),
    NOT_VALID_COACH_COUNT_MAX("코치는 최대 5명 이하로 입력해야 합니다."),
    NOT_VALID_COACH_NAME("코치 이름은 최소 2글자, 최대 4글자를 입력해야 합니다."),
    NOT_VALID_UNABLE_MENU_COUNT("못먹는 메뉴는 최대 2개만 입력해야 합니다."),
    NOT_VALID_MENU("카테고리에 해당하는 메뉴가 없습니다.");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public IllegalArgumentException throwError() {
        return new IllegalArgumentException(this.errorMessage);
    }
}
