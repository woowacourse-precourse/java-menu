package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.common.ErrorMessage;
import menu.domain.menu.Menu;

public class Coach {
    private final String name;
    private List<Menu> avoidMenu = new ArrayList<>();

    private Coach(String name) {
        validate(name);
        this.name = name;
    }

    public static Coach fromName(String coachName) {
        return new Coach(coachName);
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public void addAllAvoidMenu(List<Menu> menus) {
        this.avoidMenu.addAll(menus);
    }

    public boolean isAvoidMenu(Menu menu) {
        return avoidMenu.contains(menu);
    }
}
