package menu.exception;

public class CoachOverlappedException extends IllegalArgumentException {
    private static final String ERROR = "중복된 이름이 있습니다.";

    public CoachOverlappedException() {
        super(ERROR);
    }
}
