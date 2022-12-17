package menu.model;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum MenuCategory {
    JAPANESE_FOOD("일식")
    , KOREAN_FOOD("한식")
    , CHINESE_FOOD("중식")
    , ASIAN_FOOD("아시안")
    , WESTON_FOOD("양식")
    ;

    private final String category;

    MenuCategory(String category) {
        this.category = category;
    }

    public String getMenuCategory() {
        return category;
    }
}
