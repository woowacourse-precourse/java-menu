package menu.model.menu;

import java.util.*;

public enum Category {
    JAPANESE(1, MenuList.JAPANESE_MENU_LIST),
    KOREAN(2, MenuList.KOREAN_MENU_LIST),
    CHINESE(3, MenuList.CHINESE_MENU_LIST),
    ASIAN(4, MenuList.ASIAN_MENU_LIST),
    WESTERN(5, MenuList.WESTERN_MENU_LIST);

    private final int code;
    private final String[] menuList;
    Category(int code, String[] menuList) {
        this.code = code;
        this.menuList = menuList;
    }

    public static List<Category> getValuesWithAscendingOrder() {
        Category[] allCategory = Category.values();
        Arrays.sort(allCategory, Comparator.comparingInt(o -> o.code));

        List<Category> categoryList = new ArrayList<>();
        Collections.addAll(categoryList, allCategory);

        return categoryList;
    }

    public static Category get(int code) {
        List<Category> allCategory = getValuesWithAscendingOrder();
        if(code > allCategory.size() || code < 1) {
            throw new IllegalArgumentException("카테고리 코드는 1부터 5까지입니다.");
        }

        return allCategory.get(code - 1);
    }

    public static Category getByMenuName(String menuName) {
        List<Category> allCategory = getValuesWithAscendingOrder();
        for(Category category : allCategory) {
            if(category.getMenuList().contains(menuName)) {
                return category;
            }
        }
        throw new IllegalArgumentException(menuName + "이라는 메뉴는 등록되지 않았습니다.");
    }

    public List<String> getMenuList() {
        List<String> output = new ArrayList<>();
        Collections.addAll(output, menuList);

        return output;
    }
}
