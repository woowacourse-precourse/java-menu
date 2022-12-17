package menu.domain;

import java.util.List;

public class Category {
    String name;
    List<String> Foods;

    public Category(String name, List<String> foods) {
        this.name = name;
        Foods = foods;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoods() {
        return Foods;
    }
}
