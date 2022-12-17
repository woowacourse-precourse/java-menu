package menu.domain.food;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int number;
    private final String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Category of(int number) {
        for (Category category : values()) {
            if (category.getNumber() == number) {
                return category;
            }
        }

        throw new IllegalArgumentException("메뉴에 없는 번호입니다.");
    }

    public boolean isSameCategory(Category targetCategory) {
        return this == targetCategory;
    }
}
