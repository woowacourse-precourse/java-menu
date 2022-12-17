package menu.view.validator;

public enum Validator {
    COACH_NAME(",", "[ERROR] 코치 이름 입력이 잘못되었습니다.\n");

    private final String validDelimiter;
    private final String errorMessage;

    Validator(String validDelimiter, String errorMessage) {
        this.validDelimiter = validDelimiter;
        this.errorMessage = errorMessage;
    }

    public void validate(String input) {
        if (hasValidDelimiter(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean hasValidDelimiter(String input) {
        return !input.contains(validDelimiter);
    }

    public String getValidDelimiter() {
        return validDelimiter;
    }
}
