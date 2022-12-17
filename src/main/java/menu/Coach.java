package menu;

import java.util.List;
import java.util.Set;

public class Coach {
    private List<String> ateMenus;
    private final List<String> hateMenus;

    Coach(List<String> hateMenus) {
        this.hateMenus = hateMenus;
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
