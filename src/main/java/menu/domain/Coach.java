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
            String.format("[ERROR] 코치가 못 먹는 메뉴는 %d개를 넘어서면 안됩니다.", INEDIBLE_MENU_LIMIT);
    private final String INEDIBLE_MENU_NOT_DISTINCT = "[ERROR] 못 먹는 메뉴의 이름은 중복되어선 안됩니다.";

    public Coach(CoachName name) {
        this.name = name;
    }

    public void addInedibleMenus(List<String> inedibleMenus) {
        validateInedibleMenuSize(inedibleMenus);
        validateInedibleMenuIsDistinct(inedibleMenus);
        this.inedibleMenus.addAll(inedibleMenus);
    }

    private void validateInedibleMenuSize(List<String> menus) {
        if (menus.size() > INEDIBLE_MENU_LIMIT) {
            throw new IllegalArgumentException(INEDIBLE_MENU_SIZE_INVALID);
        }
    }

    private void validateInedibleMenuIsDistinct(List<String> inedibleMenus) {
        int distinctCount = (int) inedibleMenus.stream()
                .distinct()
                .count();

        if (distinctCount != inedibleMenus.size()) {
            throw new IllegalArgumentException(INEDIBLE_MENU_NOT_DISTINCT);
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
