package menu.util;

public enum CategoriCode {
    MIN(1),
    MAX(5),
    MAX_DUPLICATE(2);

    private final int code;

    CategoriCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
