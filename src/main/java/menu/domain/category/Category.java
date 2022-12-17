package menu.domain.category;

public enum Category {

    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String category;

    public static Category findBy(String arg) {
        for (Category category : values()) {
            if (category.category.equals(arg)) {
                return category;
            }
        }
        return null;
    }


    Category(final String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
