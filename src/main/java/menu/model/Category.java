package menu.model;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식", Menu.JAPANESE_MENU),
    KOREAN(2, "한식", Menu.KOREAN_MENU),
    CHINESE(3, "중식", Menu.CHINESE_MENU),
    ASIAN(4, "아시안", Menu.ASIAN_MENU),
    WESTERN(5, "양식", Menu.WESTERN_MENU);
    
    private final int categoryId;
    private final String categoryName;
    private final Menu categoryMenu;
    
    Category (int categoryId, String categoryName, Menu categoryMenu) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryMenu = categoryMenu;
    }

    public static Category of(int categoryId) {
        return Arrays.stream(Category.values())
                .filter(category -> category.categoryId == categoryId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 생성값이 아닙니다."));
    }

    public Menu getCategoryMenu() {
        return this.categoryMenu;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
