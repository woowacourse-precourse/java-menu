package menu.constants;

public enum CoachRules {
    MIN_NUMBER_OF_COACHES(2),
    MAX_NUMBER_OF_COACHES(5),
    MIN_NAME_LENGTH(2),
    MAX_NAME_LENGTH(4);

    private final int value;

    CoachRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
