package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

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

    public String pickMenu() {
        return Randoms.shuffle(this.category.menus).get(0);
    }
}
