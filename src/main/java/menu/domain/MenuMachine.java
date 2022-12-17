package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class MenuMachine {
    private static final MenuMachine menuMachine = new MenuMachine();

    private MenuMachine() {
    }

    public static MenuMachine getInstance() {
        return menuMachine;
    }

    public Menu recommendMenuFrom(Category category) {
        List<String> menus = Menu.getMenusOfCategory(category)
                .stream().map(Menu::getName)
                .collect(Collectors.toUnmodifiableList());

        String menu = Randoms.shuffle(menus).get(0);
        return Menu.valueOf(menu);
    }

}
