package menu.model;

import menu.utils.Serializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menus extends Serializer {
    private List<String> menus = new ArrayList<>();

    public Menus() {
    }

    public Menus(final List<String> menus) {
        this.menus = menus;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static Menus create(final String input) {
        final String[] menu = serialize(input);
        final List<String> menus = Arrays.stream(menu)
                .collect(Collectors.toList());

        return new Menus(menus);
    }

    public void addMenus(final Menus menus) {
        this.menus.addAll(menus.getMenus());
    }

    public boolean contains(final String menu) {
        return this.menus.contains(menu);
    }

    public List<String> getCloneMenus() {
        List<String> clone = new ArrayList<>();
        clone.addAll(this.menus);
        return clone;
    }
}
