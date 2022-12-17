package menu.domain;

public enum CoachCondition {
    NAME_MIN(2),
    NAME_MAX(4),
    COUNT_MIN(2),
    COUNT_MAX(5);

    private int value;

    CoachCondition(int value) {
        this.value = value;
    }

    public static boolean isWrongCoachName(String name) {
        return !(name.length() >= NAME_MIN.value && name.length() <= NAME_MAX.value);
    }

    public static boolean isWrongCoachCount(int size) {
        return !(size >= COUNT_MIN.value && size <= COUNT_MAX.value);
    }
}
