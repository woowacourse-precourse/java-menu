package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coach {
    private final CoachName name;
    private final List<String> cannotEatMenus;
    private final List<String> eatMenus = new ArrayList<>();

    private final int INEDIBLE_MENU_LIMIT = 2;
    private final String CANNOT_EAT_MENU_SIZE_INVALID =
            String.format("[ERROR] 코치가 못 먹는 음식은 %d개 이상이면 안됩니다.", INEDIBLE_MENU_LIMIT);

    public Coach(CoachName name, List<String> cannotEatMenus) {
        validateCannotEatMenus(cannotEatMenus);
        this.name = name;
        this.cannotEatMenus = cannotEatMenus;
    }

    private void validateCannotEatMenus(List<String> menus) {
        if (menus.size() > INEDIBLE_MENU_LIMIT) {
            throw new IllegalArgumentException(CANNOT_EAT_MENU_SIZE_INVALID);
        }
    }

    public void addMenu(String categoryName) {
        Category category = new Category();
        String menu = category.getRandomMenu(categoryName, getCannotEatableMenus());
        eatMenus.add(menu);
    }

    private List<String> getCannotEatableMenus() {
        return Stream.concat(cannotEatMenus.stream(), eatMenus.stream())
                .collect(Collectors.toList());
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(eatMenus);
    }

    public String getName() {
        return name.getName();
    }
}
