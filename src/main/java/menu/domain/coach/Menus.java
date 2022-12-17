package menu.domain.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menus {
    private final List<String> menus;

    private Menus() {
        menus = new ArrayList<>();
    }

    public static Menus generate() {
        return new Menus();
    }

    public void add(String menu) {
        this.menus.add(menu);
    }

    public boolean doNotHas(String menu) {
        return !menus.contains(menu);
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(menus);
    }
}
