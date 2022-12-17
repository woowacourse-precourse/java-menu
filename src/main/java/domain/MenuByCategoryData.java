package domain;

import support.FileResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MenuByCategoryData {

    private final Map<Category, List<Menu>> menuData = new HashMap<>();

    public MenuByCategoryData() throws IOException {
        FileResolver.resolveFileToMenuByCategoryData(menuData, "src/main/resources/categories.md");
    }

    public Map<Category, List<Menu>> getMenuData() {
        return menuData;
    }
}
