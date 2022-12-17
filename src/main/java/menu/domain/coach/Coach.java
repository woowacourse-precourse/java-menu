package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.Menu;
import menu.ui.dto.MenuRequest;

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
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void addAvoidMenu(Menu menu) {
        this.avoidMenu.add(menu);
    }

    public boolean isAvoidMenu(Menu menu) {
        return avoidMenu.contains(menu);
    }
}
