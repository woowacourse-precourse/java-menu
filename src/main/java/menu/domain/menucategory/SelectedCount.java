package menu.domain.menucategory;

public class SelectedCount {
    private static final int MAX_COUNT = 2;
    private static final int DEFAULT_COUNT = 0;

    private int count;

    private SelectedCount() {
        this.count = DEFAULT_COUNT;
    }

    public static SelectedCount generate() {
        return new SelectedCount();
    }

    public void add() {
        count++;
    }

    public boolean canSelect() {
        return this.count < MAX_COUNT;
    }
}
