package menu.constant;

public enum ExceptionConstants {
    NOT_ENOUGH_COACH("코치는 최소 2명 이상 입력해야 합니다."),
    TOO_MANY_COACHES("코치는 최대 5명 이하 입력해야 합니다."),
    TOO_SHORT_NAME_LENGTH("코치의 이름은 최소 2글자 이상 입력해야 합니다."),
    TOO_LONG_NAME_LENGTH("코치의 이름은 최대 4글자 이하 입력해야 합니다."),
    TOO_MANY_MENUS("못 먹는 메뉴는 최대 2개 이하 입력해야 합니다."),
    DUPLICATION("중복되지 않게 입력해야 합니다.");

    private final String message;

    ExceptionConstants(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
