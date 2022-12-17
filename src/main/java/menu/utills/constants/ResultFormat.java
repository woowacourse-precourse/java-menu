package menu.utills.constants;

public class ResultFormat {
    private static final String CATEGORY = "[ 카테고리 | %s ]";
    private static final String RECOMMENDED_MENU = "[ %s ]";

    public static String getCategoryMessage(String categoryName) {
        return String.format(CATEGORY, categoryName);
    }

    public static String getRecommendedMenuMessage(String menus) {
        return String.format(RECOMMENDED_MENU, menus);
    }
}
