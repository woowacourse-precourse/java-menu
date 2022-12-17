package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    KOREAN("한식", MenuList.KOREAN_MENU),
    JAPAN("일식", MenuList.JAPAN_MENU),
    CHINA("중식", MenuList.CHINA_MENU),
    ASIAN("아시안", MenuList.ASIAN_MENU),
    WESTERN("양식", MenuList.WESTERN_MENU),
    INVALID_CATEGORY(null, "");

    private final String categoryName;
    private final List<Menu> menuList = new ArrayList<>();

    Category(String categoryName, String menuList) {
        this.categoryName = categoryName;
        List<String> menus = List.of(menuList.replace(" ", "").split(","));
        for(String menuName: menus) {
            Menu menu = new Menu(menuName);
            this.menuList.add(menu);
        }
    }

    public static Category validateMenu(String menuName) {
        Category category = Arrays.stream(values())
                .filter(value -> value.menuList.contains(new Menu(menuName)))
                .findAny()
                .orElse(INVALID_CATEGORY);
        return category;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
