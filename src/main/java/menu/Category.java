package menu;

import java.util.Arrays;
import java.util.List;

public class Category {
    private static final List<String> categories = Arrays.asList("일식", "한식", "중식", "아시안", "양식");

    public static String getCategories(int number) {
        return categories.get(number - 1);
    }
}
