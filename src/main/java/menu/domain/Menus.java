package menu.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Menus implements Iterable<Menu>{
    private final List<Menu> menus;

    public Menus() {
        this.menus = new ArrayList<>();
    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public boolean contains(String menu) {
        return menus.contains(Menu.map(menu));
    }

    @Override
    public Iterator<Menu> iterator() {
        return menus.iterator();
    }

}
