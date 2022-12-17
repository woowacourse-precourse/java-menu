package menu.exception;

public class CoachNameLengthException extends IllegalArgumentException {
    private static final String ERROR = "이름은 2글자에서 4글자 사이입니다.";

    public CoachNameLengthException() {
        super(ERROR);
    }
}
