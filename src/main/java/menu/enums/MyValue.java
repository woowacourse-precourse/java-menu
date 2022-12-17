package menu.enums;

public enum MyValue {
    NAME_MINIMUM_SIZE(2),
    NAME_MAXIMUM_SIZE(4),
    EAT_TOGETHER_MINIMUM_SIZE(2),
    EAT_TOGETHER_MAXIMUM_SIZE(5),
    DISLIKE_FOOD_MAXIMUM_SIZE(2),
    ZERO_SETTING(0),
    CATEGORY_MINIMUM_DUPLICATE_COUNT(2),
    MONDAY(0),
    FRIDAY(4),
    SATURDAY(5);

    private int sizeValue;

    MyValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getValue() {
        return sizeValue;
    }
}
