package menu.utills.constants;

import java.util.Arrays;

public enum Category {
    JAPAN("일식",1),
    KOREA("한식",2),
    CHINA("중식",3),
    ASIA("아시안",4),
    WESTERN("양식",5);

    private final String label;
    private final int value;

    Category(String label,int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public boolean isEqual(int value) {
        return this.value == value;
    }

    public static Category getCategoryByValue(int value) {
        return Arrays.stream(Category.values())
                .filter(category -> category.isEqual(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("보기에있는 값만 입력가능합니다."));
    }
}
