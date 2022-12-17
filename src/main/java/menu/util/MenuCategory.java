package menu.util;

public enum MenuCategory {
    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    ITALIAN(5);

    private final int randomNumber;

    MenuCategory(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int get() {
        return this.randomNumber;
    }
}
