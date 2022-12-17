package menu.domain;

import java.util.Arrays;

public enum Category {

    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    AMERICAN_FOOD(5, "양식"),
    NOTHING(0,null);

    private final int command;
    private final String name;

    Category(int command, String name) {
        this.command = command;
        this.name = name;
    }

    public static Category findByCommand(int command){
        return Arrays.stream(values()).filter(category -> category.command==command)
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException("유효하지 않은 카테고리 숫자입니다"));
    }

    public int getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
