package menu.Domain;

public enum Category {
    ONE(1, "일식"),
    TWO(2, "한식"),
    THREE(3,"중식"),
    FOUR(4,"아시안"),
    FIVE(5,"양식");

    private int index;
    private String category;


    Category(int index, String category) {
        this.category = category;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getCategory() {
        return category;
    }

    public static String get(int randomNumber) {
        for (Category category : Category.values()) {
            if (category.getIndex() == randomNumber) {
                return category.getCategory();
            }
        }
        return null;
    }
}
