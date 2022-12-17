package menu.model.category;

import java.util.*;

public enum Category {
    JAPANESE(1), KOREAN(2), CHINESE(3), ASIAN(4), WESTERN(5);

    private final int code;
    Category(int code) {
        this.code = code;
    }

    public static List<Category> getValuesWithAscendingOrder() {
        Category[] allCategory = Category.values();
        Arrays.sort(allCategory, Comparator.comparingInt(o -> o.code));

        List<Category> categoryList = new ArrayList<>();
        Collections.addAll(categoryList, allCategory);

        return categoryList;
    }

    public static Category get(int code) {
        List<Category> allCategory = getValuesWithAscendingOrder();
        if(code > allCategory.size() || code < 1) {
            throw new IllegalArgumentException("카테고리 코드는 1부터 5까지입니다.");
        }

        return allCategory.get(code - 1);
    }
}
