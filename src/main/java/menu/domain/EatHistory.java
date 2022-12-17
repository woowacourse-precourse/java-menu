package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class EatHistory {
    private final List<Menu> eatMenus = new ArrayList<>();

    public EatHistory() {
    }

    public void addEatMenu(Menu menu) {
        eatMenus.add(menu);
    }

    public boolean validate(Menu menu, List<Menu> cantEat) {
        boolean result1, result2, result3;
        result1 = isNotEat(menu);
        result2 = isNotEatCategoryExceed(menu);
        result3 = isNotCantEat(menu, cantEat);
        if (result1 && result2 && result3) {
            return true;
        }
        return false;
    }

    public boolean isNotEat(Menu menu) {
        if (eatMenus.contains(menu)) {
            return false;
        }
        return true;
    }

    public boolean isNotEatCategoryExceed(Menu menu) {
        for (Menu eat : eatMenus) {
            long count = eatMenus.stream()
                    .filter(m -> m.getStyle().equals(menu.getStyle()))
                    .count();
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotCantEat(Menu menu, List<Menu> cantEat) {
        if (cantEat.contains(menu)) {
            return false;
        };
        return true;
    }

    public List<Menu> getEatMenus() {
        return eatMenus;
    }
}
