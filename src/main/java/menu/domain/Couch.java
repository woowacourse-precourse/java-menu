package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Couch {

    private final String name;
    private final Set<Menu> alreadyRecommended;
    private Map<Category, Integer> count = new HashMap<>();

    public Couch(String name, List<Menu> disableMenu) {
        this.name = name;
        this.alreadyRecommended = new LinkedHashSet<>(disableMenu);
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

    public void addDisableMenu(Menu menu) {
        count.put(menu.getCategory(), count.getOrDefault(menu, 0) + 1);
        alreadyRecommended.add(menu);
    }

    public List<Menu> getAbleMenus(List<Menu> menus) {
        List<Menu> copied = new ArrayList<>(menus);

        copied.removeAll(alreadyRecommended);

        return copied.stream().filter((menu) -> count.getOrDefault(menu.getCategory(), 0) < 2)
                .collect(Collectors.toList());
    }
}
