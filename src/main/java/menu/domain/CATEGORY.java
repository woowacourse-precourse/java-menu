package menu.domain;

public enum CATEGORY {
    JAPANESE(0, "일식"),
    KOREAN(1, "한식"),
    CHINESE(2, "중식"),
    ASIAN(3, "아시안"),
    WESTERN(4, "양식");

    private final int order;
    private final String name;

    CATEGORY(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int order() {
        return this.order;
    }

    public String getName() {
        return name;
    }
}
