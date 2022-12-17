package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.exception.InputException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Category {
    JAPANESE("일식", new Japanese()),
    KOREAN("한식", new Korean()),
    CHINESE("중식", new Chinese()),
    ASIAN("아시안", new Asian()),
    WESTERN("양식", new Western());

    private final String categoryName;
    private final AbstractCategory category;

    Category(String categoryName, AbstractCategory category) {
        this.categoryName = categoryName;
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public AbstractCategory getCategory() {
        return category;
    }

    public String pickMenu() {
        return Randoms.shuffle(this.category.menus).get(0);
    }

    public static void isValidMenu(String menu) {
        if(menu.equals(""))
            return;

        if(!allMenus().contains(menu))
            throw new IllegalArgumentException(InputException.INVALID_AVOIDANCE.getMessage());
    }

    private static Set<String> allMenus() {
        return Arrays.stream(Category.values())
                .map(Category::getCategory)
                .flatMap(AbstractCategory::getMenus)
                .collect(Collectors.toSet());
    }
}
