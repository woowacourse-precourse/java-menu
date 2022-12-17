

public class Category {

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