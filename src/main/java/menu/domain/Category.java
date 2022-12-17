package menu.domain;

public enum Category {
    JAPAN_FOOD("일식", 1),
    KOREA_FOOD("한식", 2),
    China_FOOD("중식", 3),
    Asian_FOOD("아시안", 4),
    WESTERN_FOOD("양식", 5);

    private final String name;
    private final int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
