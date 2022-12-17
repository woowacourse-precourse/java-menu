package menu.exception;

public class TooManyMenusException extends IllegalArgumentException {
    private static final String ERROR = "싫어하는 음식은 최대 두개까지 입력할 수 있습니다.";

    public TooManyMenusException() {
        super(ERROR);
    }
}
