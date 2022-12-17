package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> canNotEats;
    private final List<Menu> recommended;

    public Coach(String name) {
        this.name = name;
        this.canNotEats = new ArrayList<>();
        this.recommended = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Menu> getCanNotEats() {
        return canNotEats;
    }

    public void addCannotEats(List<Menu> menu) {
        canNotEats.addAll(menu);
    }

    public void addRecommendMenu(Menu menu) {
        recommended.add(menu);
    }

    public boolean isRecommended(Menu menu) {
        return recommended.contains(menu);
    }

    public List<Menu> getRecommended() {
        return recommended;
    }
}
