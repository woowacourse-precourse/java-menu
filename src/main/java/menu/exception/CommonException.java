package menu.exception;

public class CommonException implements InputException{
    @Override
    public void verifyException(String input) {
        checkSeperatedByComma(input, 0, 1);
        checkEmpty(input);
        checkBlank(input);
    }

    protected void checkSeperatedByComma(String input, int min, int max) {
        long count = input.chars().filter(c -> c == ',').count();
        if (count > max || count < min) {
            throw new IllegalArgumentException(ExceptionCode.NOT_SEPERATED_BY_COMMA.getMessage());
        }
    }

    protected void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.IS_EMPTY.getMessage());
        }
    }

    protected void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionCode.IS_BLANK.getMessage());
        }
    }
}
