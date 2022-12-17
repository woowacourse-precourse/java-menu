package menu.repository.constant;

public enum SizeLimit {
    COACH_MIN_SIZE(2),
    COACH_MAX_SIZE(5);

    private final int size;

    SizeLimit(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
