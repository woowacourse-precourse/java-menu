package menu.exception;

public enum InputException {
    INVALID_NAME_LENGTH("최소 2글자, 최대 4글자의 이름을 입력해야 합니다."),
    INVALID_COUNT_OF_COACHES("최소 2명, 최대 5명의 코치가 필요합니다."),
    INVALID_COUNT_OF_AVOIDANCE("못 먹는 메뉴는 0~2개 입니다."),
    INVALID_AVOIDANCE("존재하지 않는 메뉴입니다."),
    DUPLICATED_INPUT("중복된 입력이 존재합니다."),
    ;

    private final String message;
    private final String prefix = "[ERROR] ";

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
