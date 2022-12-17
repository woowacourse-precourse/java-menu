package constant;

public enum ErrorLog {
    ERROR_MARK("[ERROR]"),
    SPACE(" "),
    ZERO_NUMBER_EXCEPTION("0이 될 수 없습니다."),
    INVALID_FORM_EXCEPTION("입력이 형식에 맞지 않습니다."),
    NOT_NUMBER_INPUT_EXCEPTION("입력이 숫자가 아닙니다."),
    INVALID_NAME("이름의 길이는 2글자 이상 4글자 이하입니다."),
    INVALID_COACH_NUMBER("코치님들의 수는 2명 이상 5명 이하입니다."),
    DUPLICATION("코치님들의 이름은 중복되면 안됩니다."),
    INVALID_MENU_SIZE("못 먹는 메뉴는 2개 이하로 입력해주세요."),
    NO_MENU("기존 목록에 없는 메뉴입니다.");

    private final String log;

    ErrorLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return ERROR_MARK.log
            + SPACE.log
            + log;
    }
}