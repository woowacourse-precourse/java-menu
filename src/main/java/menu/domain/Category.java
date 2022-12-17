package menu.domain;

public enum Category {
    JP("일식", 1),
    KOR("한식", 2),
    CN("중식", 3),
    AS("아시안",4),
    WS("양식",5);

    private final String name;
    private final int num;

    Category(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public static Category getCategory(int num) {
        for (Category category : Category.values()) {
            if (category.getNum() == num) {
                return category;
            }
        }
        return null;
    }
}
