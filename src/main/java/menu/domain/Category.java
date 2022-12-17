package menu.domain;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public enum Category {
    JAPANESE(1, "일식"), KOREAN(2, "한식"), CHINESE(3, "중식"), ASIAN(4, "아시안"), WESTERN(5, "양식");

    private int code;
    private String name;

    Category(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category getMatchCategory(Predicate<Category> predicate) {
        return Arrays.stream(values()).filter(predicate).findAny().get();
    }
}
