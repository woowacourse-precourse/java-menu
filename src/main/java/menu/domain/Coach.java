package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final String BEGIN = "[ ";
    private static final String END = " ]";
    private static final String DIVISION = " | ";

    private final String name;
    private final List<String> canNotEatMenus;
    private final List<String> recommendedMenu;

    public Coach(String name, List<String> canNotEatMenus) {
        this.name = name;
        this.canNotEatMenus = canNotEatMenus;
        recommendedMenu = new ArrayList<>();
    }

    public boolean canEat(String menu) {
        if (recommendedMenu.contains(menu)) {
            return false;
        }

        if (canNotEatMenus.contains(menu)) {
            return false;
        }

        recommendedMenu.add(menu);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(BEGIN);
        String history = String.join(DIVISION, recommendedMenu);
        result.append(history);
        result.append(END);

        return result.toString();
    }

}
