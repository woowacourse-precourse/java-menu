package menu.exception;

public class MenuNameBlankException extends IllegalArgumentException {
    private static final String ERROR = "음식의 이름은 공백일 수 없습니다.";

    public MenuNameBlankException() {
        super(ERROR);
    }
}
