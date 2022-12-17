package menu.domain.coach;

import java.util.List;

public class Coach {
    private final String name;
    private final Menus recommendedMenus = Menus.generate();
    private final Menus hateMenus = Menus.generate();

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
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

    public List<String> getRecommendedMenus() {
        return recommendedMenus.getAll();
    }
}
