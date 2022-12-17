package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {

    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    WESTERN("양식");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Category> getList() {
        return Arrays.stream(Category.values())
                .sequential()
                .collect(Collectors.toList());
    }
}
