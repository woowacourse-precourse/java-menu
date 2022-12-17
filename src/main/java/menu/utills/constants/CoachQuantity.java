package menu.utills.constants;

public enum CoachQuantity {
    MIN(2),
    MAX(5);

    private final int quantity;

    CoachQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
