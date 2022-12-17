package support;

import domain.Category;
import domain.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class FileResolver {

    private FileResolver() {}

    public static void resolveFileToMenuByCategoryData(Map<Category, List<Menu>> menuData, String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] categoryAndMenus = line.split(",");
            Category categoryName = Category.findCategoryByName(categoryAndMenus[0]);

            String[] menus = categoryAndMenus[1].split(", ");

            menuData.put(categoryName, generateMenusName(menus));
        }
    }

    private static List<Menu> generateMenusName(String[] menus) {
        List<Menu> menusName = new ArrayList<>();
        for (String menu : menus) {
            menusName.add(new Menu(menu));
        }
        return menusName;
    }
}
