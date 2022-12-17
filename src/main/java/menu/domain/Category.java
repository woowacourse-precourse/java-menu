package menu.domain;

import java.util.Collections;
import java.util.List;

public class Category {

    private final String name;
    private final List<String> menu;

    public Category(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return Collections.unmodifiableList(menu);
    }

    public boolean isExistMenu(String menu) {
        return this.menu.contains(menu) || menu.equals("");
    }
}
