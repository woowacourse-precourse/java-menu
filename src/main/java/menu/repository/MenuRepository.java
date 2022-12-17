package menu.repository;

import menu.domain.Category;
import menu.domain.Menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.Map;

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
}
