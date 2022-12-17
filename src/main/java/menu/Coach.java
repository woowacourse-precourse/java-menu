package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private String name;
    private List<String> hateFoods;
    private List<String> categories;
    private Map<String, Integer> categoriesCounter = initCounter();

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String toString() {
        return categories.toString();
    }

    public boolean isValidCategory(String category) {
        if (categoriesCounter.get(category) + 1 < 3) {
            categoriesCounter.put(category,categoriesCounter.getOrDefault(category, 0) + 1);
            return true;
        }

        return false;
    }

    private Map<String, Integer> initCounter() {
        Map<String, Integer> counter = new HashMap<>();

        counter.put(Category.getCategories(1), 0);
        counter.put(Category.getCategories(2), 0);
        counter.put(Category.getCategories(3), 0);
        counter.put(Category.getCategories(4), 0);
        counter.put(Category.getCategories(5), 0);

        return counter;
    }
}
