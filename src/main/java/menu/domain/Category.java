package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN(1, "일식", MenuList.JAPAN_MENU),
    KOREAN(2, "한식", MenuList.KOREAN_MENU),
    CHINA(3, "중식", MenuList.CHINA_MENU),
    ASIAN(4, "아시안", MenuList.ASIAN_MENU),
    WESTERN(5, "양식", MenuList.WESTERN_MENU),
    INVALID_CATEGORY(-1, null, "");

    private final int categoryNumber;
    private final String categoryName;
    private final List<Menu> menuList = new ArrayList<>();

    Category(int categoryNumber, String categoryName, String menuList) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
        List<String> menus = List.of(menuList.replace(" ", "").split(","));
        for(String menuName: menus) {
            Menu menu = new Menu(menuName);
            this.menuList.add(menu);
        }
    }

    public static Category makeCategory(int number) {
        Category category = Arrays.stream(values())
                .filter(value -> value.categoryNumber == number)
                .findAny()
                .orElse(INVALID_CATEGORY);
        return category;
    }

    public static Category validateMenu(String menuName) {
        Category category = Arrays.stream(values())
                .filter(value -> value.menuList.contains(new Menu(menuName)))
                .findAny()
                .orElse(INVALID_CATEGORY);
        return category;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
