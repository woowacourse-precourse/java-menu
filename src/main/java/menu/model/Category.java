package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final List<String> categories;

    public Category() {
        categories = new ArrayList<>();
        categories.add("카테고리");
    }

    public List<String> getCategories() {
        return categories;
    }
}
