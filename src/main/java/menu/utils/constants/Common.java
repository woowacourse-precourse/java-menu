package menu.utils.constants;

public enum Common {

    MIN_COACH_NUMBER(2),
    MAX_COACH_NUMBER(5),
    MIN_COACH_NAME_LENGTH(2),
    MAX_COACH_NAME_LENGTH(4),
    MAX_UNEATABLE_FOOD(2),
    MAX_SAME_CATEGORY(2),
    NUMBER_OF_DATE(5),

    ;

    private final int number;

    Common(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
