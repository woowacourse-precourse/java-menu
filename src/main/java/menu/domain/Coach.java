package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final Menus hateMenus;
    private final Menus recommended;

    public Coach(String name) {
        this.name = name;
        this.hateMenus = new Menus();
        this.recommended = new Menus();
    }

    public void addHateMenu(Menu menu) {
        hateMenus.addMenu(menu);
    }

    public void addRecommendedMenu(Menu menu) {
        if (unAcceptable(menu)) {
            return;
        }
        recommended.addMenu(menu);
    }

    public boolean isAllRecommended() {
        return recommended.containFiveMenus();
    }

    public String getRecommendedMenuNames() {
        List<String> messages = new ArrayList<>();
        messages.add(this.name);
        System.out.println(recommended);
        messages.add(recommended.toString());
        return String.join(" | ", messages);
    }

    private boolean unAcceptable(Menu menu) {
        return hateMenus.contains(menu)
                || recommended.contains(menu)
                || recommended.duplicatedCategory(menu);
    }
}
