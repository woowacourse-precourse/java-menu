package domain;

import support.FileResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuByCategoryData {

    private Map<Category, List<Menu>> menuData;

    public MenuByCategoryData() throws IOException {
        menuData = FileResolver.resolveFileToMenuByCategoryData("src/main/resources/categories.md");
    }


    public boolean hasMenu(String name) {
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
