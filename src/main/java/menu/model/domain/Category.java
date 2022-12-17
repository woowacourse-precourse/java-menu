package menu.model.domain;

import java.util.Arrays;

public enum Category {

    JAPAN("일식", 1),
    KOREA("한식", 2),
    CHINA("중식", 3),
    ASIA("아시안", 4),
    AMERICA("양식", 5);

    private String category;
    private Integer index;

    Category(String category, Integer index) {
        this.category = category;
        this.index = index;
    }

    public String getCategory() {
        return category;
    }

    public Integer getIndex() {
        return index;
    }

    public static Category getValueOf(Integer inputIndex) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getIndex().equals(inputIndex))
                .findFirst().orElse(null);
    }
}
