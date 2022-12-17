package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private String name;
    private List<String> hateFoods;
    private List<String> categories;

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
}
