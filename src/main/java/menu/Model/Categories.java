package menu.Model;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private final List<Category> categories;

    public Categories() {
        categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getCategoryNames() {
        return List.of("일식", "한식", "중식", "아시안", "양식");
    }
}
