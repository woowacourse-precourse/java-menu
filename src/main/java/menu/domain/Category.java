package menu.domain;

public enum Category {
    JP("일식"), KOR("한식"), CN("중식"), AS("아시안"), WS("양식");
    private final String name;

    Category(String name) {
        this.name = name;
    }
}
