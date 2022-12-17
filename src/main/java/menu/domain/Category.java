package menu.domain;

import menu.util.ResourceReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPAN("일식", "src/main/resources/japan-menu.md", 1),
    KOREA("한식", "src/main/resources/korea-menu.md", 2),
    CHINA("중식", "src/main/resources/china-menu.md", 3),
    ASIAN("아시안", "src/main/resources/asian-menu.md", 4),
    WESTERN("양식", "src/main/resources/western-menu.md", 5);

    private final String name;

    private final String filePath;

    private final Integer index;

    public static List<String> getCategoryWithMenus(Category category, ResourceReader resourceReader) {
        return resourceReader.readResource(category.filePath);
    }

    public static Category getCategoryByIdx(int index) {
        return Arrays.stream(Category.values())
                .filter(category -> index == category.index)
                .findFirst()
                .orElseThrow();
    }

    public static String getCategoryNames(List<Category> categories) {
        List<String> categoryNames = categories.stream().map(category -> category.name).collect(Collectors.toList());
        return "[ 카테고리 | " + String.join(" | ", categoryNames) + " ]\n";
    }


    Category(String name, String filePath, Integer index) {
        this.name = name;
        this.filePath = filePath;
        this.index = index;
    }



}
