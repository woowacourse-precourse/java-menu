package menu.domain.model;

public enum Category {

    JAPAN_FOOD(1, "일식"),
    KOREA_FOOD(2, "한식"),
    CHINA_FOOD(3, "중식"),
    ASIA_FOOD(4, "아시아"),
    EUROPE_FOOD(4, "양식");

    private final int number;
    private final String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
