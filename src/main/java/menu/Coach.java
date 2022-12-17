package menu;

import java.util.*;

public class Coach {
    private final Set<String> ateMenus;
    private final HashSet<String> hateMenus;

    Coach(String[] hateMenus) {
        this.hateMenus = new HashSet<>();
        this.hateMenus.addAll(Arrays.asList(hateMenus));
        this.ateMenus = new HashSet<>();
    }

    public boolean checkIsHateMenu(String menu) {
        return hateMenus.contains(menu);
    }

    public void addAteMenus(String menu) {
        ateMenus.add(menu);
    }

    public boolean checkIsAteMenu(String menu) {
        return ateMenus.contains(menu);
    }
}
