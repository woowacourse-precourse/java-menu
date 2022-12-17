package menu.domain.coach;

import java.util.List;

public class Coach {
    private final String name;
    private final Menus recommendedMenus = Menus.generate();
    private final Menus hateMenus = Menus.generate();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(String menu) {
        hateMenus.add(menu);
    }

    public void recommend(String menu) {
        recommendedMenus.add(menu);
    }

    private boolean isNotRecommended(String menu) {
        return recommendedMenus.doNotHas(menu);
    }

    private boolean likeMenu(String menu) {
        return hateMenus.doNotHas(menu);
    }

    public boolean canRecommend(String menu) {
        return isNotRecommended(menu) && likeMenu(menu);
    }

    public List<String> getRecommendedFoods() {
        return recommendedMenus.getAll();
    }
}
