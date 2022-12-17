package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();
    private List<Menu> recommended = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public String getName() {
        return name;
    }

    public boolean isHate(Menu menu) {
        return hateMenus.contains(menu);
    }

    public void addRecommend(Menu menu) {
        recommended.add(menu);
    }

    public List<Menu> getRecommended() {
        return recommended;
    }
}
