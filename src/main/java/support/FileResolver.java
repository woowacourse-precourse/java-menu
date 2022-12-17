package support;

import domain.Category;
import domain.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FileResolver {

    private FileResolver() {}

    public static Map<Category, List<Menu>> resolveFileToMenuByCategoryData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        Map<Category, List<Menu>> menuData = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] categoryAndMenus = line.trim().split(":");
            Category categoryName = Category.findCategoryByName(categoryAndMenus[0]);

            String[] menus = categoryAndMenus[1].trim().split(", ");

            menuData.put(categoryName, generateMenusName(menus));
        }
        return menuData;
    }

    private static List<Menu> generateMenusName(String[] menus) throws IOException {
        List<Menu> menusName = new ArrayList<>();
        for (String menu : menus) {
            menusName.add(new Menu(menu));
        }
        return menusName;
    }
}
