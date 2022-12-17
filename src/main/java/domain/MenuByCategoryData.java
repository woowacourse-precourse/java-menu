package domain;

import support.FileResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuByCategoryData {

    private static Map<Category, List<Menu>> menuData;

    static {
        try {
            menuData = FileResolver.resolveFileToMenuByCategoryData("src/main/resources/categories.md");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasMenu(String name) throws IOException {
        boolean isEqual = false;
        for (Category category : menuData.keySet()) {
            List<Menu> menus = menuData.get(category);
            if (menus.contains(new Menu(name))) {
                isEqual = true;
            }
        }
        return isEqual;
    }

}
