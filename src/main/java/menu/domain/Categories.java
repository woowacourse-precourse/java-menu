package menu.domain;

import java.util.Collections;
import java.util.List;

public class Categories {

    private final List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }
}
