package menu;

public enum ErrorFormat {

    NEED_MORE_COUCH("코치는 최소 2명 이상 입력해야 합니다"),
    INVALID_MENU_NAME("유효하지 않은 메뉴 이름입니다");
    private final String message;

    ErrorFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
