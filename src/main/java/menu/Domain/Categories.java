package menu.Domain;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private static List<String> categories = new ArrayList<>();

    public static void addCategory(String category) {
        categories.add(category);
    }

    public static void clear() {
        categories.clear();
    }

    public static boolean validateCategory() {
        for (String category : categories) {
            if (compareRepetition(category) > 2) {
                    return false;
            }
        }
        return true;
    }

    private static int compareRepetition(String category) {
        int repetitionCounter = 0;
        for (String categoryTo : categories) {
            if (category.equals(categoryTo)) {
                repetitionCounter++;
            }
        }
        return repetitionCounter;
    }

    public static List<String> getCategories() {
        return categories;
    }

}
