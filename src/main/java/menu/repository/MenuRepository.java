package menu.repository;

import menu.domain.Category;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MenuRepository {
    private static final Map<Category, Menus> menus = new EnumMap<>(Category.class);

    static {
        load();
    }

    private static void load() {
        try {
            BufferedReader reader
                    = Files.newBufferedReader(Paths.get("src/main/resources/Menus.md"));
            reader.lines()
                    .map(menuByCategory -> menuByCategory.split(": "))
                    .forEach(menuByCategory -> menus.put(
                            Category.fromName(menuByCategory[0]),
                            Menus.from(menuByCategory[0], menuByCategory[1])
                            )
                    );
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 에러");
        }
    }

    public static Menus findMenus(List<String> menuNames) {
        return menuNames.stream()
                .map(menuName -> findMenu(menuName))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Menus::new));
    }

    private static Menu findMenu(String name) {
        Menu menu = allMenus().findMenu(name);
        if (Objects.isNull(menu)) {
            throw new IllegalArgumentException("존재 않는 메뉴");
        }
        return menu;
    }

    private static Menus allMenus() {
        return menus.values().stream()
                .map(Menus::getMenus)
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), Menus::new));
    }
}
