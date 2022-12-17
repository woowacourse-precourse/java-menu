package menu.domain.enumeration;

public enum Food {
    KYUDONG("일식", "규동"),
    WOODONG("일식", "우동"),
    MISOSIROO("일식","미소시루"),
    SHUSHI("일식","스시"),
    KACHEDONG("일식","가츠동"),
    ONIGIRI("일식","오니기리"),
    HIRICE("일식","하이라이스"),
    RAMEN("일식","라멘"),
    OKONOMI("일식","오코노미야끼"),

    KIMBAB("한식","김밥"),
    KIMCHI_STEW("한식","김치찌개"),
    SAMBAB("한식","쌈밥"),
    BEAN_STEW("한식","된장찌개"),
    BIBIMBAB("한식","비빔밥"),
    KALNOODLE("한식","칼국수"),
    BULLMEET("한식","불고기"),
    TUKBOKKI("한식","떡볶이"),
    JEYUKPORK("한식","제육볶음");

    private final String foodName;
    private final String category;

    Food(String category, String foodName) {
        this.foodName = foodName;
        this.category = category;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public String getCategory() {
        return this.category;
    }

    public static Food[] getAllFood() {
        return Food.values();
    }
}
