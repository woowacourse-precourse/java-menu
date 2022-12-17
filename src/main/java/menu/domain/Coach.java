package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coach {
    private final CoachName name;
    private final List<String> menus = new ArrayList<>();
    private final List<String> inedibleMenus = new ArrayList<>();

    private final int INEDIBLE_MENU_LIMIT = 2;
    private final String INEDIBLE_MENU_SIZE_INVALID =
            String.format("[ERROR] 코치가 못 먹는 음식은 %d개 이상이면 안됩니다.", INEDIBLE_MENU_LIMIT);

    public Coach(CoachName name) {
        this.name = name;
    }

    public void addInedibleMenus(List<String> inedibleMenus) {
        validateCannotEatMenus(inedibleMenus);
        this.inedibleMenus.addAll(inedibleMenus);
    }

    private void validateCannotEatMenus(List<String> menus) {
        if (menus.size() > INEDIBLE_MENU_LIMIT) {
            throw new IllegalArgumentException(INEDIBLE_MENU_SIZE_INVALID);
        }
    }

    public void addMenu(String categoryName) {
        Category category = new Category();
        String menu = category.getRandomMenu(categoryName, getInedibleMenus());
        menus.add(menu);
    }

    private List<String> getInedibleMenus() {
        return Stream.concat(inedibleMenus.stream(), menus.stream())
                .collect(Collectors.toList());
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public String getName() {
        return name.getName();
    }
}
