package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Couch {

    private final String name;
    private final Set<Menu> alreadyRecommended = new LinkedHashSet<>();

    public Couch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAlreadyRecommended(Menu menu) {
        return alreadyRecommended.contains(menu);
    }

    public void recommendMenu(Menu menu) {
        alreadyRecommended.add(menu);
    }

    public List<Menu> getAbleMenus(List<Menu> menus) {
        List<Menu> copied = new ArrayList<>(menus);

        copied.removeAll(alreadyRecommended);
        return copied;
    }
}
