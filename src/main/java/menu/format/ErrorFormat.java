package menu.format;

public enum ErrorFormat {

    INVALID_COUCH_COUNTS("코치는 최소 2명 이상, 최대 5명까지만 가능합니다"),
    DUPLICATED_NAME("이름은 중복될 수 없습니다"),
    INVALID_COUCH_NAME("코치 이름은 2글자에서 4글자 사이여야 합니다"),
    INVALID_COUNT_OF_MENU("0~2개 사이의 음식만 못먹을 수 있습니다"),
    INVALID_MENU_NAME("유효하지 않은 메뉴 이름입니다");
    private final String message;

    ErrorFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
