package menu.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.repository.MenuRepository;
import menu.view.OutputView;

public class MenuConfig {

    private MenuConfig() {
    }

    public static void configure() {
        try {
            BufferedReader reader = getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                storeMenus(line);
            }
        } catch (IOException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private static BufferedReader getReader() throws IOException {
        return new BufferedReader(new FileReader("src/main/resources/category.md"));
    }

    private static void storeMenus(String line) {
        List<String> categoryPerMenus = getCategoryPerMenus(line);
        Category category = Category.from(categoryPerMenus.get(0));
        List<String> menus = getMenus(categoryPerMenus.get(1));
        for (String menu : menus) {
            MenuRepository.addMenu(category, menu);
        }
    }

    private static List<String> getCategoryPerMenus(String line) {
        return Arrays.stream(line.split(":"))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    private static List<String> getMenus(String menus) {
        return Arrays.stream(menus.split(","))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }
}
