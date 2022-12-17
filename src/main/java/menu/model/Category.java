package menu.model;

public enum Category {
    JAPANESE(1), KOREAN(2), CHINESE(3), ASIAN(4), WESTERN(5);

    private final int value;
    private Category(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}
