package menu.view.constant;

public enum RecommendationStyle {
    START("[ "),
    END(" ]"),
    DELIMITER(" | "),
    DAY("구분"),
    CATEGORY("카테고리");

    private final String style;

    RecommendationStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
