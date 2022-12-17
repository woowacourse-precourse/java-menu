package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private final CoachName name;
    private final List<String> cannotEatMenus;
    private final List<String> eatMenus = new ArrayList<>();

    private final String CANNOT_EAT_MENU_SIZE_INVALID = "[ERROR] 코치가 못 먹는 음식은 2개 이상이면 안됩니다.";

    public Coach(CoachName name, List<String> cannotEatMenus) {
        validateCannotEatMenus(cannotEatMenus);
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }

    private void validateCannotEatMenus(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException(CANNOT_EAT_MENU_SIZE_INVALID);
        }
    }

    public void addMenu(String categoryName) {
        Category category = new Category();
        String menu;
        do {
            menu = category.getRandomMenu(categoryName);
        } while (!isEatable(menu) && !isNotDuplicated(menu));
        eatMenus.add(menu);
    }

    private boolean isEatable(String menu) {
        return !cannotEatMenus.contains(menu);
    }

    private boolean isNotDuplicated(String menu) {
        return !eatMenus.contains(menu);
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(eatMenus);
    }

    public String getName() {
        return name.getName();
    }
}
