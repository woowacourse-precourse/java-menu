package menu.domain.coach.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.domain.menu.entity.Menu;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private static final String NAME_EXCEPTION_MESSAGE = "이름은 최소 %d글자, 최대 %d글자여야 합니다.";

    private final String name;
    private final List<Menu> inedibleMenus = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        int nameLength = name.length();

        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_EXCEPTION_MESSAGE, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public void addAllInedibleMenus(List<Menu> menus) {
        inedibleMenus.addAll(menus);
    }

    public boolean matchesByName(String name) {
        return this.name.equals(name);
    }

    public boolean matchesByInedibleMenu(Menu menu) {
        return inedibleMenus.contains(menu);
    }

    public String getName() {
        return name;
    }
}
