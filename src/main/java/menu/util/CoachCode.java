package menu.util;

public enum CoachCode {
    MIN_MEMBER(2),
    MAX_MEMBER(5),
    MIN_NAME(2),
    MAX_NAME(4),
    MIN_FOOD(0),
    MAX_FOOD(2);
    private final int code;

    CoachCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
