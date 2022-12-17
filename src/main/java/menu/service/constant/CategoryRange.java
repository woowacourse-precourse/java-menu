package menu.service.constant;

public enum CategoryRange {
    MIN(1),
    MAX(5);

    private final int range;

    CategoryRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
