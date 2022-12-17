package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> foods;

    public Category(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
