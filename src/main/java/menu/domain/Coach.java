package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> cannotEatMenus;
    private final List<String> eatMenus = new ArrayList<>();

    public Coach(String name, List<String> cannotEatMenus) {
        validateName(name);
        validateCannotEatMenus(cannotEatMenus);
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자에서 4글자만 가능합니다.");
        }
    }

    private void validateCannotEatMenus(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 코치가 못 먹는 음식은 2개 이상이면 안됩니다.");
        }
    }


}
