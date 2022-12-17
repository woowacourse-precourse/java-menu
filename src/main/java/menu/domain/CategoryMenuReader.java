package menu.domain;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CategoryMenuReader {
    private static final CategoryMenuReader categoryMenuReader = new CategoryMenuReader();

    private static final String CATEGORY_SEPARATOR = ":";
    private static final int CATEGORY_INDEX = 0;
    private static final String MENU_SEPARATOR = ",";
    private static final int MENU_INDEX = 1;

    private CategoryMenuReader() {
    }

    public static CategoryMenuReader getInstance() {
        return categoryMenuReader;
    }

    public Map<Category, List<String>> readCategoryMenus(String filePath) throws IOException {
        Map<String, List<String>> readContent = readFile(filePath);
        Map<Category, List<String>> categoryMenus = new EnumMap<>(Category.class);

        readContent.forEach(
                (category, menus)
                        -> categoryMenus.put(Category.getCategoryByName(category), menus));

        return categoryMenus;
    }


    private Map<String, List<String>> readFile(String filePath) throws IOException {
        Map<String, List<String>> categoryMenu = new HashMap<>();

        Scanner scanner = new Scanner(new File(filePath));
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String category = getCategory(line);
            List<String> menus = getMenus(line);
            categoryMenu.put(category, menus);
        }
        return categoryMenu;
    }

    private String getCategory(String line) {
        String[] category = line.split(CATEGORY_SEPARATOR);
        return category[CATEGORY_INDEX].strip();
    }

    private List<String> getMenus(String line) {
        String[] category = line.split(CATEGORY_SEPARATOR);
        return Arrays.stream(category[MENU_INDEX].split(MENU_SEPARATOR))
                .map(String::strip)
                .collect(Collectors.toUnmodifiableList());
    }

}
