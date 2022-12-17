package menu.domain.menu;

import java.util.Iterator;
import java.util.List;

public class Menus implements Iterable<Menu>{
    private List<Menu> menus;

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
