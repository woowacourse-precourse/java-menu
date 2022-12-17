package menu.model;

public class Category {
    private static final String[] categories = {"", "일식", "한식", "중식", "아시안", "양식"};

    public static String getName(int number) {
        return categories[number];
    }
}
