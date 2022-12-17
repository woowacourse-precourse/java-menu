package menu.domain.category;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    public final List<Category> categories;

    public Categories() {
        this.categories = new ArrayList<>();
    }

    public void add(Category category) {
        categories.add(category);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 카테고리 | ");

        for (int i = 0; i < categories.size(); i++) {
            stringBuilder.append(categories.get(i).getCategory());
            if (i != categories.size() - 1) {
                stringBuilder.append(" | ");
            }
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
