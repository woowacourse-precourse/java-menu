package menu;

import java.util.*;

public class Coach {
    private final List<String> ateMenus;
    private final HashSet<String> hateMenus;
    private final String name;

    Coach(String name, String[] hateMenus) {
        this.name = name;
        this.hateMenus = new HashSet<>();
        this.hateMenus.addAll(Arrays.asList(hateMenus));
        this.ateMenus = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<String> getAteMenus() {
        return this.ateMenus;
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
