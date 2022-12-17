package menu.domain;

public enum InputException {
    DUPLICATE_COACH_NAME("중복된 코치 이름입니다."),
    OUT_OF_COACH_NAME_COUNT_MINIMUM("코치는 최소 2명 이상 입력해야 합니다."),
    OUT_OF_COACH_NAME_COUNT_MAXIMUM("코치는 최대 5명 이하로 입력해야 합니다."),
    OUT_OF_COACH_NAME_LENGTH_MINIMUM("코치 이름은 최소 2글자 이상 입력해야 합니다."),
    OUT_OF_COACH_NAME_LENGTH_MAXIMUM("코치 이름은 최대 4글자 이하로 입력해야 합니다."),
    DUPLICATE_COACH_MENUS("중복된 메뉴가 입력되었습니다."),
    INVALID_MENU("지원하지 않는 메뉴 이름입니다.");


    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}