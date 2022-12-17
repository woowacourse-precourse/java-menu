package menu.domain;

public enum Category {
    JAPANESE(0),
    KOREAN(1),
    CHINESE(2),
    ASIAN(3),
    WESTERN(4);

    private final int order;

    Category(int order) {
        this.order = order;
    }

    public int order() {
        return this.order;
    }
}
