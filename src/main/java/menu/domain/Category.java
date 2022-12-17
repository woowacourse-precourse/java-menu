package menu.domain;

public enum Category {
    KOREAN(1),
    JAPAN(0),
    CHINA(2),
    ASIAN(3),
    WESTERN(4);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
