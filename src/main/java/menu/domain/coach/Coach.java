package menu.domain.coach;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> selectedMenu = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void selectMenu(List<String> menus) {
        menus.removeIf(selectedMenu::contains);
        String menu = Randoms.shuffle(menus).get(0);
        selectedMenu.add(menu);
    }
}
