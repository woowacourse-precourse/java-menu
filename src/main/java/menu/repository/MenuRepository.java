package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MenuRepository {
    private static final String FILE_PATH = "src/main/resources/Menus.md";
    private static final Map<Category, Menus> menus = new EnumMap<>(Category.class);
    private static final String CATEGORY_MENUS_DELIMITER = ": ";

    static {
        load();
    }

    private static void load() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            load(reader);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 에러");
        }
    }

    private static void load(BufferedReader reader) {
        reader.lines()
                .map(menuByCategory -> menuByCategory.split(CATEGORY_MENUS_DELIMITER))
                .forEach(menuByCategory -> saveMenus(menuByCategory[0], menuByCategory[1]));
    }

    private static Menus saveMenus(String category, String menus) {
        return MenuRepository.menus.put(
                Category.fromName(category),
                Menus.from(category, menus)
        );
    }

    public static Menus findMenus(List<String> menuNames) {
        return menuNames.stream()
                .map(menuName -> findMenu(menuName))
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), Menus::new));
    }

    private static Menu findMenu(String name) {
        Menu menu = allMenus().findMenu(name);
        if (Objects.isNull(menu)) {
            throw new IllegalArgumentException("존재 않는 메뉴");
        }
        return menu;
    }

    public static Menus allMenus() {
        return menus.values().stream()
                .map(Menus::getMenus)
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), Menus::new));
    }
}
