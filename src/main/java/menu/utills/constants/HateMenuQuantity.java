package menu.utills.constants;

public enum HateMenuQuantity {
    MIN(0),
    MAX(2);

    private final int quantity;

    HateMenuQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
