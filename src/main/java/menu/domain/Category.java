package menu.domain;

import java.util.*;

public class Category {

    private final String categoryName;
    private final List<String> menus;

    private Category(String categoryName, List<String> menus) {
        this.categoryName = categoryName;
        this.menus = new ArrayList<>();
        this.menus.addAll(menus);
    }

    public static Category createCategory(String categoryName, List<String> menus) {
        return new Category(categoryName, menus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName) && Objects.equals(menus, category.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, menus);
    }
}
