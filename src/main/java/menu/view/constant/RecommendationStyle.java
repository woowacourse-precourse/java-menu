package menu.view.constant;

public enum RecommendationStyle {
    START("[ "),
    END(" ]"),
    DELIMITER(" | ");

    private final String style;

    RecommendationStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
