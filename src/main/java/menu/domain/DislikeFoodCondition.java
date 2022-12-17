package menu.domain;

public enum DislikeFoodCondition {
    MIN_COUNT(0),
    MAX_COUNT(2);
    private final int value;

    DislikeFoodCondition(int value) {
        this.value = value;
    }

    public static boolean isWrongDislikeFoodCount(int size) {
        return size >= MIN_COUNT.value && size <= MAX_COUNT.value;
    }
}
