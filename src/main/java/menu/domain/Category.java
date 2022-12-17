package menu.domain;

import menu.util.ResourceReader;

import java.util.List;

public enum Category {
    JAPAN("일식", "src/main/resources/japan-menu.md")
    , KOREA("한식", "src/main/resources/korea-menu.md")
    , CHINA("중식", "src/main/resources/china-menu.md")
    , ASIAN("아시안", "src/main/resources/asian-menu.md")
    , WESTERN("양식", "src/main/resources/western-menu.md");

    private final String name;

    private final String filePath;

    public static List<String> getCategoryWithMenus(Category category, ResourceReader resourceReader) {
        return resourceReader.readResource(category.filePath);
    }

    Category(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }
}
