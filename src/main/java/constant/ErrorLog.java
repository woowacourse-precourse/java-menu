package constant;

public enum ErrorLog {
    ERROR_MARK("[ERROR]"),
    SPACE(" "),
    ZERO_NUMBER_EXCEPTION("0이 될 수 없습니다."),
    INVALID_FORM_EXCEPTION("입력이 형식에 맞지 않습니다."),
    NOT_NUMBER_INPUT_EXCEPTION("입력이 숫자가 아닙니다.");

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