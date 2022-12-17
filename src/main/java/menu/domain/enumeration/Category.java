package menu.domain.enumeration;

import java.util.Arrays;

public enum Category {

    JAPAN(1,"일식"),
    KOREAN(2,"한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "서양");

    private final Integer categoryIndex;
    private final String categoryName;

    Category(Integer categoryIndex, String categoryName) {
        this.categoryIndex = categoryIndex;
        this.categoryName = categoryName;
    }

    public Integer getCategoryIndex() {
        return this.categoryIndex;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public static String findCategoryName(Integer index) {
        return Arrays.stream(Category.values())
                .filter(category -> category.categoryIndex.equals(index))
                .findAny()
                .map(Category::getCategoryName)
                .orElse(null);
    }
}
