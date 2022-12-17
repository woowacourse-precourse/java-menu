package menu.exception;

public class NameIsBlankException extends IllegalArgumentException {
    private static final String ERROR = "이름은 공백일 수 없습니다.";

    public NameIsBlankException() {
        super(ERROR);
    }
}
