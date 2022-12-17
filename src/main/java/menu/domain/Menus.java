package menu.domain;

import menu.utills.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
    private final List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public boolean contains(Menu menu) {
        return menus.contains(menu);
    }

    @Override
    public String toString() {
        List<String> menuNames = menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        return Converter.toStringByDelimiter(menuNames);
    }
}
