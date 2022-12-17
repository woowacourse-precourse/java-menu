package menu.exception;

public class NoSuchMenuException extends IllegalArgumentException {
    private static final String ERROR = "목록에 없는 메뉴입니다 : ";

    public NoSuchMenuException(String name) {
        super(ERROR + name);
    }
}
