package menu.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Menus {

    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus createMenus(List<String> names) {
        return new Menus(names.stream()
                .map(Menu::new)
                .collect(toUnmodifiableList()));
    }

    public Menu pickShuffledMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
