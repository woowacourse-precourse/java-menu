package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CouchRepository {

    private static List<Couch> couches = new ArrayList<>();
    private static List<Category> selectedCategories = new ArrayList<>();


    public static void addCouch(Couch couch) {
        couches.add(couch);
    }

    public static List<Couch> getCouches() {
        return couches;
    }

    public static List<Category> getSelectedCategories() {
        return selectedCategories;
    }

    public static void addCategory(Category selectedCategory) {
        selectedCategories.add(selectedCategory);

    }

    public static boolean validateMenu(Category selectedCategory) {
        int sameCategoryCount = (int) selectedCategories.stream()
                .filter(category -> category.equals(selectedCategory))
                .count();
        if (sameCategoryCount >= 2) {
            return false;
        }
        return true;
    }
}
