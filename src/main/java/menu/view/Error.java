package menu.view;

public class Error extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] %s";

    public Error(String msg) {
        System.out.println(String.format(ERROR, msg));
        throw new IllegalArgumentException();
    }
}
