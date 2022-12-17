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

    public static void validateMenu(Category selectedCategory) {

    }
}
