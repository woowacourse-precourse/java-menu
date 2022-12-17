package menu.utills.constants;

public enum CoachNameRule {
    MIN(2),
    MAX(4);

    private final int length;

    CoachNameRule(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
