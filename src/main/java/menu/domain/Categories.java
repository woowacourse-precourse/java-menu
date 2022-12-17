package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.enums.Category;

public class Categories {
    private final List<Category> categories = new ArrayList<>();

    public Categories(final List<Category> categories) {
        this.categories.addAll(categories);
    }
}
