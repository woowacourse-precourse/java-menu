package menu.domain.menu;

import java.util.Arrays;

public enum FoodStyle {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    ITALIAN(5, "중식");

    private final int index;
    private final String style;

    FoodStyle(int index, String style) {
        this.index = index;
        this.style = style;
    }

    public int getIndex() {
        return index;
    }

    public String getStyle() {
        return style;
    }

    public static FoodStyle getFoodStyle(int code) {
        return Arrays.stream(values())
                .filter(foodStyle -> foodStyle.getIndex() == code)
                .findAny()
                .orElseGet(null);
    }
}
