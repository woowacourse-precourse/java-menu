package menu;

import java.util.List;

public class Category {

    private final List<Integer> positions;

    public Category(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
