package menu.exception;

public class CoachDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 코치들의 이름은 중복될 수 없습니다.";

    public CoachDuplicateException() {
        super(String.format(ERROR_MESSAGE));
    }
}
