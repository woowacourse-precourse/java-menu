package menu;

import camp.nextstep.edu.missionutils.Randoms;

public class Category {

    public Category() {
    }

    public String getCategory() {
        String category = typeToCategory(Randoms.pickNumberInRange(1, 5));
        return category;
    }

    public String typeToCategory(int type) {
        if (type == CategoryType.JAPAN.getType()) {
            return CategoryType.JAPAN.getCategory();
        }
        if (type == CategoryType.KOREA.getType()) {
            return CategoryType.KOREA.getCategory();
        }
        if (type == CategoryType.CHINA.getType()) {
            return CategoryType.CHINA.getCategory();
        }
        if (type == CategoryType.ASIAN.getType()) {
            return CategoryType.ASIAN.getCategory();
        }
        return CategoryType.WESTERN.getCategory();
    }

}

enum CategoryType {

    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int type;
    private final String category;

    CategoryType(int type, String category) {
        this.type = type;
        this.category = category;
    }

    public int getType() {
        return this.type;
    }

    public String getCategory() {
        return this.category;
    }
}